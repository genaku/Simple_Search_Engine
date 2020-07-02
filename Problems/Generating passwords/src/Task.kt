import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val upper = scanner.nextInt()
    val lower = scanner.nextInt()
    val digits = scanner.nextInt()
    val chars = scanner.nextInt()
    val diff = chars - upper - lower - digits
    println(makePassword(upper, lower + diff, digits, chars))
}

fun makePassword(upper: Int, lower: Int, digits: Int, chars: Int): String {
    var password = ""
    var lastChar = ' '
    var currentUpper = 0
    var currentLower = 0
    var currentDigits = 0
    val upperChars = ('A'..'Z')
    val lowerChars = ('a'..'z')
    val allowedDigits = ('0'..'9')
    val allowedChars = upperChars + lowerChars + allowedDigits
    while (password.length < chars) {
        val nextChar = allowedChars.random()
        if (nextChar != lastChar) {
            when (nextChar) {
                in upperChars -> {
                    if (currentUpper < upper) {
                        lastChar = nextChar
                        password += nextChar
                        currentUpper++
                    }
                }
                in lowerChars -> {
                    if (currentLower < lower) {
                        lastChar = nextChar
                        password += nextChar
                        currentLower++
                    }
                }
                in allowedDigits -> {
                    if (currentDigits < digits) {
                        lastChar = nextChar
                        password += nextChar
                        currentDigits++
                    }
                }
            }
        }
    }
    return password
}