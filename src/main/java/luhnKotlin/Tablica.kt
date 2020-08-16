package luhnKotlin

class Tablica {
    fun splitStringToArray(s: String) {
        val pattern = "".toRegex()
        val words = pattern.split(s).filter { it.isNotBlank() }
        for (word in words) {
            println(word.toInt())
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Tablica()
            t.splitStringToArray("1234")
        }
    }
}