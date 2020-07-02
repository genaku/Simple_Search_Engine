import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var result = 0
    do {
        val value = scanner.nextInt()
        if (result < value) {
            result = value
        }
    } while (value != 0)
    println(result)
}