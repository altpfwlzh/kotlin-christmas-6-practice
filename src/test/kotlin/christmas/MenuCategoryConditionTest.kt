package christmas

import christmas.model.order.Menu
import christmas.model.orderCondition.MenuCategoryCondition
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenuCategoryConditionTest {
    @Test
    fun `음료만 주문하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MenuCategoryCondition(mapOf(Menu.ZERO_COKE to 2))
        }
    }
}