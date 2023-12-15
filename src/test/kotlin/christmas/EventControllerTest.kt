package christmas

import christmas.controller.EventController
import christmas.model.event.GiftEventChampagne
import christmas.model.order.Menu
import christmas.model.order.OrderMenus
import christmas.model.order.VisitDate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class EventControllerTest {

    private val visitDate = VisitDate(3)
    private val menusOver120000 =
        OrderMenus(mapOf(Menu.T_BONE_STEAK to 1, Menu.BBQ_RIB to 1, Menu.CHOCO_CAKE to 2, Menu.ZERO_COKE to 1))
    @Test
    fun `테스트 이름`() {
        val result = EventController(visitDate, menusOver120000).calculateDiscountEventNameAndDiscountAmount()
        println(result)
    //Assertions.assertEquals(, result)
    }

    @Test
    fun `테스트 이름2`() {
        val result = GiftEventChampagne(visitDate, menusOver120000).isSatisfy
        println(result)
        //Assertions.assertEquals(, result)
    }
}