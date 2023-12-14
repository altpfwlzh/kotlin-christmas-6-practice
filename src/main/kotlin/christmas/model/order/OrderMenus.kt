package christmas.model.order

class OrderMenus(private val menus: Map<Menu, Int> ) {

    init {
        require(!isExistMenu()) {throw IllegalArgumentException(INVALID_MENU)}
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

    companion object {
        const val INVALID_MENU = "메뉴판에 없는 메뉴를 입력했습니다."
    }
}