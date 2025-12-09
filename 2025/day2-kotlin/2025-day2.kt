///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2025-day2-input.kt

fun runPart1(input: String): Long{
    val ranges = input.split(",").map {
        val parts = it.split("-")
        Pair(parts.first().toLong(), parts.last().toLong())
    }
    val result = ranges.sumOf { pair ->
        (pair.first..pair.second).filter {
            val s = it.toString()
            s.take(s.length/2) == s.substring(s.length/2)
        }.sum()
    }
    return result
}

fun run(input: String) {
    val part1Result = runPart1(input)
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