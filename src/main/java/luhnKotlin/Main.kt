package luhnKotlin

import luhnKotlin.Luhn

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val luhn = Luhn()
        println(luhn.validate("22558894"))
        println(luhn.calculateCheckDigit("2255889"))
    }
}