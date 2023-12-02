package christmas.model.order

enum class MenuCategory(val string: String) {
    DEFAULT("분류 없음"),
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료")
}

enum class Menu(val menuCategory: MenuCategory, val price: Int, val string: String) {
    DEFAULT(MenuCategory.DEFAULT, 0, "메뉴 없음"),
    MUSHROOM_SOUP(MenuCategory.APPETIZER, 6_000, "양송이수프"),
    TAPAS(MenuCategory.APPETIZER, 5_500, "타파스"),
    CAESAR_SALAD(MenuCategory.APPETIZER, 8_000, "시저샐러드"),

    T_BONE_STEAK(MenuCategory.MAIN, 55_000, "티본스테이크"),
    BARBECUE_LIP(MenuCategory.MAIN, 54_000, "바비큐립"),
    SEAFOOD_PASTA(MenuCategory.MAIN, 35_000, "해산물파스타"),
    CHRISTMAS_PASTA(MenuCategory.MAIN, 25_000, "크리스마스파스타"),

    CHOCOLATE_CAKE(MenuCategory.DESSERT, 15_000, "초코케이크"),
    ICE_CREAM(MenuCategory.DESSERT, 5_000, "아이스크림"),

    ZERO_COKE(MenuCategory.DRINK, 3_000, "제로콜라"),
    RED_WINE(MenuCategory.DRINK, 60_000, "레드와인"),
    CHAMPAGNE(MenuCategory.DRINK, 25_000, "샴페인")
    ;

    companion object {
        fun valueOf(string: String): Menu {
            return Menu.values().first { string == it.string }
        }
    }
}