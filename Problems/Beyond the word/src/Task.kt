import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val v = scanner.next()
    for (c in ('a'..'z')) {
        if (v.contains(c)) {
            continue
        }
        print(c)
    }
}