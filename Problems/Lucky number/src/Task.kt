import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val input = scanner.next()
    val halfLen = input.length / 2
    val left = input.substring(0, halfLen)
    val right = input.substring(halfLen)
    val leftValue = getSum(left)
    val rightValue = getSum(right)
    println(if (leftValue == rightValue) "YES" else "NO")
}

fun getSum(str: String): Int {
    var value = 0
    for (ch in str) {
        value += ch.toInt()
    }
    return value
}