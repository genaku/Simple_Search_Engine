import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val v = scanner.next()
    for (c in v) {
        if (c.isDigit()) {
            println(c)
            return
        }
    }
}