package christmas

import christmas.model.order.Menu
import christmas.model.order.OrderMenus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OrderMenusTest {
    @Test
    fun `없는 메뉴를 입력하면 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            OrderMenus(mapOf(Menu.NONE to 0))
        }
    }
}