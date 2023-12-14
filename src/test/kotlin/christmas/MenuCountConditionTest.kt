package christmas

import christmas.model.order.Menu
import christmas.model.orderCondition.MenuCountCondition
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenuCountConditionTest {
    @Test
    fun `메뉴가 1개 미만일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MenuCountCondition(mapOf(Menu.CHOCO_CAKE to 0))
        }
    }

    @Test
    fun `메뉴가 20개 초과일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            MenuCountCondition(mapOf(Menu.CHOCO_CAKE to 2, Menu.T_BONE_STEAK to 1, Menu.BBQ_RIB to 15, Menu.ZERO_COKE to 10))
        }
    }
}