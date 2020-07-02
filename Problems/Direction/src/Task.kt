import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val dir = scanner.nextInt()
    println(when (dir) {
        1 -> "move up"
        2 -> "move down"
        3 -> "move left"
        4 -> "move right"
        0 -> "do not move"
        else -> "error!"
    })
}