import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val max = scanner.nextInt()
    var sq = 1
    var res = sq * sq
    while (res <= max) {
        println(res)
        sq++
        res = sq * sq
    }
}