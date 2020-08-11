package luhnKotlin

import luhnJava.LuhnJava
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class LuhnCalculateCheckDigitTest(private val numberInCase: String, private val checkDigitInCase: Int) {

    var luhn: LuhnJava? = LuhnJava()

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: isValid({0})={1}")
        fun data(): Iterable<Array<Any>> {
            return arrayListOf(arrayOf("2255889", 4), arrayOf("35328501174149", 3), arrayOf("92480", 3)).toList()
        }
    }

    @Test
    fun calculateCheckDigit() {
        val actual = luhn!!.calculateCheckDigit(numberInCase)
        Assert.assertEquals(checkDigitInCase, actual)
    }


}