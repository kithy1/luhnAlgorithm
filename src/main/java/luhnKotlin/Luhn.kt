package luhnKotlin

public class Luhn {

    fun validate(number: String?): Boolean {
        val reverseNumber = reverseStringRepresentationOfNumber(number)

        var sumOfDigitsOnOddIndex = 0
        var sumOfDigitsOnEvenIndex = 0
        val sumOfAllDigits: Int

        var i = 0
        while (i < reverseNumber.length) {
            sumOfDigitsOnOddIndex += reverseNumber[i].toString().toInt()
            i += 2
        }

        var j = 1
        while (j < reverseNumber.length) {
            var digitOnEvenIndex = reverseNumber[j].toString().toInt()
            digitOnEvenIndex *= 2
            if (digitOnEvenIndex > 9) {
                digitOnEvenIndex = (digitOnEvenIndex % 10) + 1
            }
            sumOfDigitsOnEvenIndex += digitOnEvenIndex
            j += 2
        }

        sumOfAllDigits = sumOfDigitsOnEvenIndex + sumOfDigitsOnOddIndex
        val modOfSumOfAllDigits = (sumOfAllDigits % 10)
        return modOfSumOfAllDigits == 0
    }
    fun calculateCheckDigit(number: String?): Int {
        val reverseNumber = reverseStringRepresentationOfNumber(number)

        var sumOfDigitsOnOddIndex = 0
        var sumOfDigitsOnEvenIndex = 0
        val sumOfAllDigits: Int

        var i = 0
        while (i < reverseNumber.length) {
            sumOfDigitsOnOddIndex += reverseNumber[i].toString().toInt()
            i += 2
        }

        var j = 1
        while (j < reverseNumber.length) {
            var digitOnEvenIndex = reverseNumber[j].toString().toInt()
            digitOnEvenIndex *= 2
            if (digitOnEvenIndex > 9) {
                digitOnEvenIndex = (digitOnEvenIndex % 10) + 1
            }
            sumOfDigitsOnEvenIndex += digitOnEvenIndex
            j += 2
        }

        sumOfAllDigits = sumOfDigitsOnEvenIndex + sumOfDigitsOnOddIndex
        val modOfSumOfAllDigits = (sumOfAllDigits % 10)

        return if(modOfSumOfAllDigits==0){
            0
        } else {
            10-modOfSumOfAllDigits
        }
    }
    private fun reverseStringRepresentationOfNumber(number: String?): String{
        return StringBuilder(number).reverse().toString()
    }

}