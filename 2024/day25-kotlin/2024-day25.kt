///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day25-input.kt

typealias Heights = List<Int>

private const val FILLED = '#'

fun run(input: String) {
    val keysAndLocks = input.split("\n\n")
    val keys = mutableListOf<Heights>()
    val locks = mutableListOf<Heights>()
    keysAndLocks.forEach {
        val lines = it.lines()
        val heights = List(lines[0].count()) { 0 }.toMutableList()
        for (j in lines[0].indices) {
            for (i in 1..<lines.lastIndex) {
                if (lines[i][j] == FILLED) heights[j] += 1
            }
        }
        if (lines[0].any { it == FILLED }) keys.add(heights) else locks.add(heights)
    }
    val maxHeight = keysAndLocks[0].lines().count() - 2
    println("keys:\n${keys.joinToString(",")}")
    println("locks:\n${locks.joinToString(",")}")
    println("max height: $maxHeight")

    var part1Result = 0
    for (key in keys) {
        for (lock in locks) {
            val fits = key.zip(lock).all { it.first + it.second <= maxHeight }
            if (fits) part1Result += 1
        }
    }
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