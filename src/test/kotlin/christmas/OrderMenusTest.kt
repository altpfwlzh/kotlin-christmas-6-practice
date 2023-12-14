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

    @Test
    fun `주문 메뉴 내역을 바르게 출력하는지 확인한다`() {
        val menus = mapOf(Menu.T_BONE_STEAK to 1, Menu.BBQ_RIB to 1, Menu.CHOCO_CAKE to 2, Menu.ZERO_COKE to 1)
        val result = OrderMenus(menus).getMenusKeyToString()
        println(result)
    }
}