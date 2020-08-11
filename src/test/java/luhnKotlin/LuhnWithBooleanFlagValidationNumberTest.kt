package luhnKotlin

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class LuhnWithBooleanFlagValidationNumberTest(private val numberInCase: String, private val isValid: Boolean) {

    var luhn = LuhnWithBooleanFlag()

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: isValid({0})={1}")
        fun data(): Iterable<Array<Any>> {
            return arrayListOf(arrayOf("22558894", true), arrayOf("353285011741493", true), arrayOf("924803", true), arrayOf("353951299398328", true), arrayOf("372180072157182", false)).toList()
        }
    }

    @Test
    fun calculateCheckDigit() {
        val actual = luhn!!.validate(numberInCase)
        Assert.assertEquals(isValid, actual)
    }
}