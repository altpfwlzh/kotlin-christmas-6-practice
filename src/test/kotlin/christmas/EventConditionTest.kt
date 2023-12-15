package christmas

import christmas.model.eventCondition.EventConditionDay
import christmas.model.eventCondition.EventConditionPeriod
import christmas.model.eventCondition.EventConditionPrice
import christmas.model.order.Menu
import christmas.model.order.MenuCategory
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.DayOfWeek
import java.time.LocalDate

class EventConditionTest {
    private val visitDate = VisitDate(3)
    private val menusOver120000 =
        OrderMenus(mapOf(Menu.T_BONE_STEAK to 1, Menu.BBQ_RIB to 1, Menu.CHOCO_CAKE to 2, Menu.ZERO_COKE to 1))
    private val menusUnder120000 = OrderMenus(mapOf(Menu.T_BONE_STEAK to 1))

    @Test
    fun `12만원을 넘으면 조건을 만족한다`() {
        val result = EventConditionPrice(visitDate, menusOver120000, MenuCategory.NONE, 120_000).isSatisfy
        Assertions.assertEquals(true, result)
    }

    @Test
    fun `12월 3일은 일요일이다`() {
        val result = EventConditionDay(visitDate, menusOver120000, listOf(DayOfWeek.SUNDAY)).isSatisfy
        Assertions.assertEquals(true, result)
    }

    @Test
    fun `12월 3일은 12월 한 달 안에 포함된다`() {
        val result = EventConditionPeriod(
            visitDate,
            menusOver120000,
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31)
        ).isSatisfy
        Assertions.assertEquals(true, result)
    }


}