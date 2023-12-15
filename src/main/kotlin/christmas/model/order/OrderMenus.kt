package christmas.model.order

import christmas.constants.ErrorMessage
import christmas.model.orderCondition.MenuCategoryCondition
import christmas.model.orderCondition.MenuCondition
import christmas.model.orderCondition.MenuCountCondition

class OrderMenus(private val menus: Map<Menu, Int> ) {
    private val conditions: List<MenuCondition> = listOf(MenuCountCondition(menus), MenuCategoryCondition(menus))

    init {
        require(!isExistMenu()) {throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MENUS + INVALID_MENU)}
        require(conditions.all { it.isSatisfy }) {throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MENUS)}
    }

    private fun isExistMenu() = menus.contains(Menu.NONE)

    fun getMenusKeyToString(): Map<String, Int> {
        val menusDetail: MutableMap<String, Int> = mutableMapOf()

        menus.map {
            menusDetail[it.key.string] = it.value
        }
        return menusDetail
    }

    fun calculateTotalPrice(): Int {
        var totalPrice: Int = 0

        menus.map {
            totalPrice += (it.key.price * it.value)
        }
        return totalPrice
    }

    fun calculateTotalPrice(menuCategory: MenuCategory): Int {
        var totalPrice: Int = 0

        menus.filter {
            it.key.menuCategory == menuCategory
        }.map {
            totalPrice += (it.key.price * it.value)
        }
        return totalPrice
    }

    fun calculateMenuCategoryCount(menuCategory: MenuCategory): Int {
        var totalCount: Int = 0

        menus.filter {
            it.key.menuCategory == menuCategory
        }.map {
            totalCount += it.value
        }

        return totalCount
    }

    companion object {
        const val INVALID_MENU = "메뉴판에 없는 메뉴를 입력했습니다."
    }
}