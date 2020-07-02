import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val v = scanner.next()
    var letters = 0
    for (c in ('a'..'z')) {
        var count = 0
        for (z in v) {
            if (z == c) {
                count++
            }
        }
        if (count == 1) {
            letters++
        }
    }
    println(letters)
}