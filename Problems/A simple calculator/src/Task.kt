import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val left = scanner.nextLong()
    val op = scanner.next()
    val right = scanner.nextLong()
    println(when (op) {
        "+" -> "${left + right}"
        "-" -> "${left - right}"
        "*" -> "${left * right}"
        "/" -> if (right == 0L) "Division by 0!" else "${left / right}"
        else -> "Unknown operator"
    })
}