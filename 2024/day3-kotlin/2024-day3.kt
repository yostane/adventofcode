///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES input.kt

import kotlin.math.abs
import kotlin.time.Duration.Companion.seconds

fun sumOfMul(input: String) =
    """mul\((?<l>\d+),(?<r>\d+)\)""".toRegex().findAll(input).sumOf {
        val l = it.groups["l"]?.value?.toLong() ?: 0
        val r = it.groups["r"]?.value?.toLong() ?: 0
        l * r
    }

fun run(input: String, input2: String = input) {
    val part1Result = sumOfMul(input)
    println("part1 $part1Result")

    val part2Result = input2.split("do()").map { it.split("don't")[0] }.sumOf {
        sumOfMul(it)
    }
    println("part2 $part2Result")
}

fun main() {
    println("Sample input")
    run(testInput, testInput2)
    println("Puzzle input")
    run(input)
}