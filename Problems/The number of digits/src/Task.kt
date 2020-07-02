import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val value = scanner.nextInt()
    println(when(value){
        in 0..9 -> "1"
        in 10..99 -> "2"
        in 100..999 -> "3"
        in 1000..9999 -> "4"
        else -> ""
    })
}