package search

import java.io.File
import java.lang.Exception
import java.util.*

val scanner = Scanner(System.`in`)
var lines = listOf<String>()
val invertedIndex = mutableMapOf<String, MutableSet<Int>>()

fun main(args: Array<String>) {
    if (args.size > 1) {
        parseArg(args[0], args[1])
    }
    while (true) {
        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit")
        val menuItem = scanner.nextInt()
        scanner.nextLine()
        when (menuItem) {
            1 -> findPersons(selectStrategy())
            2 -> printAll()
            0 -> {
                println("Bye!")
                return
            }
            else -> println("Incorrect option! Try again.")
        }
    }
}

fun parseArg(command: String, filename: String) {
    when (command) {
        "--data" -> import(filename)
    }
}

fun import(filename: String) {
    try {
        val file = File(filename)
        lines = file.readLines()
    } catch (e: Exception) {
        println("File not found.")
    }
    makeInvertedIndex()
}

fun makeInvertedIndex() {
    lines.forEachIndexed { idx, it ->
        it.split(' ').forEach {
            val a = invertedIndex[it.toLowerCase()] ?: mutableSetOf()
            a.add(idx)
            invertedIndex[it.toLowerCase()] = a
        }
    }
}

fun printAll() {
    lines.forEach {
        println(it)
    }
}

fun selectStrategy(): SearchStrategy? {
    println("Select a matching strategy: ALL, ANY, NONE")
    return SearchStrategy.findByName(scanner.nextLine())
}

fun findPersons(strategy: SearchStrategy?) {
    strategy ?: return
    println("Enter a name or email to search all suitable people.")
    val queries = scanner.nextLine().split(' ')
    val foundIds = strategy.findPersons(queries)
    if (foundIds.isEmpty()) {
        println("No matching people found.")
    } else {
        println("${foundIds.size} persons found:")
        foundIds.forEach {
            println(lines[it])
        }
    }
}

fun findPersonIdsByQuery(query: String): Set<Int> = invertedIndex[query.toLowerCase()] ?: emptySet()

enum class SearchStrategy(val findPersons: (queries: List<String>) -> Set<Int>) {
    ALL({ queries ->
        val result = mutableSetOf<Int>()
        val size = queries.size
        val idMap = mutableMapOf<Int, Int>()
        queries.forEach { query ->
            findPersonIdsByQuery(query).forEach {
                idMap[it] = (idMap[it] ?: 0) + 1
            }
        }
        idMap.forEach { (key, value) -> if (value == size) result.add(key) }
        result
    }),
    ANY({ queries ->
        val result = mutableSetOf<Int>()
        queries.forEach {
            findPersonIdsByQuery(it).forEach { result.add(it) }
        }
        result
    }),
    NONE({ queries ->
        val result = mutableSetOf<Int>()
        for (i in lines.indices) {
            result.add(i)
        }
        queries.forEach {
            findPersonIdsByQuery(it).forEach { result.remove(it) }
        }
        result
    });

    companion object {
        fun findByName(name: String): SearchStrategy? = values().firstOrNull { it.name == name.toUpperCase() }
    }
}