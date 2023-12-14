package christmas.model.orderCondition

import christmas.constants.ErrorMessage
import christmas.model.order.Menu
import christmas.model.order.MenuCategory

class MenuCategoryCondition(override val menus: Map<Menu, Int>) : MenuCondition(menus) {
    override val isSatisfy: Boolean = isNotOnlyDrinks()

    init {
        require(isNotOnlyDrinks()) {throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MENUS + ONLY_DRINK_NOT_ALLOW)}
    }

    private fun isNotOnlyDrinks(): Boolean {
        menus.map {
            if(it.key.menuCategory != MenuCategory.DRINK) return true
        }
        return false
    }

    companion object {
        const val ONLY_DRINK_NOT_ALLOW = "음료만 주문하는 것은 불가능합니다."
    }
}