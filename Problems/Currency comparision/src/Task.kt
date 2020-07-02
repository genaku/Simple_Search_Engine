import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val currency1 = Countries.getByName(input.next())?.currency
    val currency2 = Countries.getByName(input.next())?.currency
    println(currency1 != null && currency2 != null && currency1 == currency2)
}

enum class Countries(val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar");

    companion object {
        fun getByName(name: String): Countries? = values().firstOrNull { it.name == name }
    }
}