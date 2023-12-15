package christmas.model.order

enum class MenuCategory(val string: String) {
    NONE("없음"),
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료")
}

enum class Menu(val menuCategory: MenuCategory, val string: String, val price: Int) {
    //NONE
    NONE(MenuCategory.NONE, "없음", 0),

    // Appetizer
    MUSHROOM_SOUP(MenuCategory.APPETIZER, "양송이수프", 6_000),
    TAPAS(MenuCategory.APPETIZER, "타파스", 5_500),
    CAESAR_SALAD(MenuCategory.APPETIZER, "시저샐러드", 8_000),

    // Main
    T_BONE_STEAK(MenuCategory.MAIN, "티본스테이크", 55_000),
    BBQ_RIB(MenuCategory.MAIN, "바비큐립", 54_000),
    SEAFOOD_PASTA(MenuCategory.MAIN, "해산물파스타", 35_000),
    CHRISTMAS_PASTA(MenuCategory.MAIN, "크리스마스파스타", 25_000),

    // Dessert
    CHOCO_CAKE(MenuCategory.DESSERT, "초코케이크", 15_000),
    ICE_CREAM(MenuCategory.DESSERT, "아이스크림", 5_000),

    // Drink
    ZERO_COKE(MenuCategory.DRINK, "제로콜라", 3_000),
    RED_WINE(MenuCategory.DRINK, "레드와인", 60_000),
    CHAMPAGNE(MenuCategory.DRINK, "샴페인", 25_000)
    ;

    companion object {
        fun valueOf(string: String): Menu {
            return Menu.values().associateBy(Menu::string)[string] ?: NONE
        }
    }
}