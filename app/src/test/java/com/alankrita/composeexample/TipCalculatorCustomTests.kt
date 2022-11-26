import com.alankrita.composeexample.ui.TipCalculatorCustom
import org.junit.Assert
import org.junit.Test

class TipCalculatorCustomTests {

    @Test
    fun calculate_20_percent_tip_no_roundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = "$2.00"
        val actualTip = TipCalculatorCustom().calculateTip(amount = amount, tipPercent = tipPercent, false)
        Assert.assertEquals(expectedTip, actualTip)
    }
}