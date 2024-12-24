///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day24-input.kt

data class Operation(val x: String, val y: String, val operation: String, val result: String) {
    fun apply(x: Boolean, y: Boolean) = when (operation) {
        "XOR" -> x.xor(y)
        "OR" -> x.or(y)
        "AND" -> x.and(y)
        else -> throw Error("Operation not supported $operation")
    }
}

fun run(input: String) {
    val (registriesLines, operationsLines) = input.split("\n\n")
    val registries = registriesLines.lineSequence().map {
        val key = it.substringBefore(":")
        val value = it.substringAfter(": ").toInt() != 0
        key to value
    }.toMap().toMutableMap()

    val operations = operationsLines.lineSequence().map {
        val parts = it.split(" ")
        Operation(parts[0], parts[2], parts[1], parts.last())
    }.toMutableSet()

    while (operations.isNotEmpty()) {
        val operation = operations.first { it.x in registries.keys && it.y in registries.keys }
        val x = registries.getOrElse(operation.x) { throw Error("Key x not found ${operation.x}") }
        val y = registries.getOrElse(operation.y) { throw Error("Key y not found ${operation.y}") }
        registries[operation.result] = operation.apply(x, y)
        operations.remove(operation)
    }

    val sortedZs = registries.filter { it.key.startsWith("z") }.toSortedMap().reversed()
    println(sortedZs)

    val part1Result = sortedZs.map { if (it.value) '1' else '0' }.joinToString("").toLong(2)
    println("part1 $part1Result")

    val part2Result = 0
    println("part2 $part2Result")
}

fun main() {
    println("Sample inputs")
    sampleInputs.forEachIndexed { i, input ->
        println("Sample input $i")
        run(input)
    }
    println("Puzzle input")
    run(input)
}