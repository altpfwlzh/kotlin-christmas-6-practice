package christmas.model.order

class OrderMenus(private val menus: Map<Menu, Int> ) {

    init {
        require(!isExistMenu()) {throw IllegalArgumentException(INVALID_MENU)}
    }

    private fun isExistMenu() = menus.contains(Menu.NONE)

    companion object {
        const val INVALID_MENU = "메뉴판에 없는 메뉴를 입력했습니다."
    }
}