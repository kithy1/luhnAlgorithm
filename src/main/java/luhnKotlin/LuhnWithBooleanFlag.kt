package luhnKotlin

class LuhnWithBooleanFlag : LuhnAlgorithm {

    override fun calculateCheckDigit(number: String?): Int {
        val sumOfDigits = calculateSumOfBaseDigits(number).toLong()
        val mod = (sumOfDigits % 10).toInt()

        return if (mod == 0) 0 else 10 - mod
    }

    override fun validate(number: String?): Boolean {
        val checkDigit = number!!.substring(number.length - 1).toInt()
        val baseNumber = number.substring(0, number.length - 1)
        val sumOfBaseDigits = calculateSumOfBaseDigits(baseNumber)
        val sum = sumOfBaseDigits + checkDigit
        return sum % 10 == 0
    }

 companion object {
     private fun calculateSumOfBaseDigits(baseNumber: String?): Int {
         var index = baseNumber!!.length
         var numberProcessing = true
         var sum = 0

         while (index > 0) {
             if (numberProcessing) {
                 var digitOnEvenIndex = baseNumber.substring(index - 1, index).toInt()
                 digitOnEvenIndex *= 2
                 if (digitOnEvenIndex > 9) {
                     digitOnEvenIndex = digitOnEvenIndex % 10 + 1
                 }
                 sum += digitOnEvenIndex
                 numberProcessing = false
             } else {
                 sum += baseNumber.substring(index - 1, index).toInt()
                 numberProcessing = true
             }
             index--
         }
         return sum
     }
 }
}