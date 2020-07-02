import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine()
            .toLowerCase() + " "
            .replace(',', ' ')
            .replace('.', ' ')
            .replace('!', ' ')
            .replace('?', ' ')
    println(input.indexOf("the"))
}