package christmas.controller

import christmas.model.event.DiscountEvent
import christmas.model.event.DiscountEventChristmasDDay
import christmas.model.event.DiscountEventSpecialStar
import christmas.model.event.DiscountEventWeekday
import christmas.model.event.DiscountEventWeekend
import christmas.model.event.GiftEvent
import christmas.model.event.GiftEventChampagne
import christmas.model.event.RewardEvent
import christmas.model.event.RewardEventBadge
import christmas.model.order.Menu
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate

class EventController(visitDate: VisitDate, menus: OrderMenus) {
    private val giftEvents: List<GiftEvent> = listOf(GiftEventChampagne(visitDate, menus))
    private val discountEvents: List<DiscountEvent> = listOf(
        DiscountEventChristmasDDay(visitDate, menus),
        DiscountEventSpecialStar(visitDate, menus),
        DiscountEventWeekday(visitDate, menus),
        DiscountEventWeekend(visitDate, menus)
    )
    private val rewardEvents: List<RewardEvent> = listOf(RewardEventBadge(visitDate, menus, 0))

    private val satisfyGiftEvents: List<GiftEvent> = calculateSatisfyGiftEvent()
    private val satisfyDiscountEvents: List<DiscountEvent> = calculateSatisfyDiscountEvent()
    private val satisfyRewardEvents: List<RewardEvent> = calculateSatisfyRewardEvent()

    private fun calculateSatisfyGiftEvent(): List<GiftEvent> = giftEvents.filter { it.isSatisfy }
    private fun calculateSatisfyDiscountEvent(): List<DiscountEvent> = discountEvents.filter { it.isSatisfy }
    private fun calculateSatisfyRewardEvent(): List<RewardEvent> = rewardEvents.filter { it.isSatisfy }

    fun calculateGiftMenuAndCount(): Map<Menu, Int> {
        val giftDetails: MutableMap<Menu, Int> = mutableMapOf()
        satisfyGiftEvents.map {
            giftDetails += it.giftMenuAndCount
        }

        return giftDetails
    }

    fun calculateDiscountEventNameAndDiscountAmount(): Map<String, Int> {
        val discountDetails: MutableMap<String, Int> = mutableMapOf()
        satisfyDiscountEvents.map {
            discountDetails[it.eventName] = it.discountMenuCategoryAndAmount.values.first()
        }

        return discountDetails
    }

    fun calculateGiftEventNameAndGiftAmount(): Map<String, Int> {
        val giftDetails: MutableMap<String, Int> = mutableMapOf()
        satisfyGiftEvents.map {
            giftDetails[it.eventName] = it.giftMenuAndCount.keys.first().price
        }

        return giftDetails
    }

    fun calculateTotalDiscountAmount(): Int {
        var totalDiscountAmount: Int = 0
        satisfyDiscountEvents.map {
            totalDiscountAmount += it.discountMenuCategoryAndAmount.values.first()
        }

        return totalDiscountAmount
    }

    fun calculateTotalGiftAmount(): Int {
        var totalDiscountAmount: Int = 0
        satisfyGiftEvents.map {
            totalDiscountAmount += it.giftMenuAndCount.keys.first().price
        }

        return totalDiscountAmount
    }

}