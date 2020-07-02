import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var result = 0
    do {
        val value = scanner.nextInt()
        result += value
    } while (value != 0)
    println(result)
}