package christmas

import christmas.model.order.Menu
import christmas.model.order.OrderMenus
import christmas.model.orderCondition.MenuCategoryCondition
import christmas.model.orderCondition.MenuCountCondition
import org.junit.jupiter.api.Assertions
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

    @Test
    fun `주문한 메뉴들의 총금액을 올바르게 출력한다`() {
        val menus = mapOf(Menu.T_BONE_STEAK to 1, Menu.BBQ_RIB to 1, Menu.CHOCO_CAKE to 2, Menu.ZERO_COKE to 1)
        val result = OrderMenus(menus).calculateTotalPrice()
        Assertions.assertEquals(142_000, result)
    }

    @Test
    fun `음료만 주문하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            OrderMenus(mapOf(Menu.ZERO_COKE to 2))
        }
    }

    @Test
    fun `메뉴가 1개 미만일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            OrderMenus(mapOf(Menu.CHOCO_CAKE to 0))
        }
    }

    @Test
    fun `메뉴가 20개 초과일 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            OrderMenus(mapOf(Menu.CHOCO_CAKE to 2, Menu.T_BONE_STEAK to 1, Menu.BBQ_RIB to 15, Menu.ZERO_COKE to 10))
        }
    }
}