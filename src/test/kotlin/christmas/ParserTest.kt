package christmas

import christmas.model.order.Menu
import org.junit.jupiter.api.Test
import christmas.util.Parser
import org.junit.jupiter.api.Assertions

class ParserTest {
    @Test
    fun `형식을 올바르게 변경한다`() {
        val result = Parser().stringToOrderMenus("티본 스테이크- 1,바비큐립-1,초코케이크-2,제로콜라-1")
        Assertions.assertEquals(mapOf(Menu.T_BONE_STEAK to 1, Menu.BBQ_RIB to 1, Menu.CHOCO_CAKE to 2, Menu.ZERO_COKE to 1), result)
    }
}