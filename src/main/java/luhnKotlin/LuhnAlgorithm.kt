package luhnKotlin

interface LuhnAlgorithm {

    fun calculateCheckDigit(number: String?): Int
    fun validate(number: String?): Boolean
}