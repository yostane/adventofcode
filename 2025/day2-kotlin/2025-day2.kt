///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2025-day2-input.kt

fun loadIntoRanges(input: String) = input.splitToSequence(",").map {
    val parts = it.split("-")
    Pair(parts.first().toLong(), parts.last().toLong())
}

fun runPart1(input: String): Long{
    val ranges = loadIntoRanges(input)
    val result = ranges.sumOf { pair ->
        (pair.first..pair.second).filter {
            val s = it.toString()
            s.take(s.length/2) == s.substring(s.length/2)
        }.sum()
    }
    return result
}

fun isIdPart2Invalid(id: String) = (1..id.length / 2).any { subStringLength ->
    val sequence = id.substring(0, subStringLength)
    Regex("^(${sequence})+$").matches(id)
}


fun runPart2(input: String): Long {
    val ranges = loadIntoRanges(input)
    val result = ranges.sumOf { pair ->
        (pair.first..pair.second).filter {
            isIdPart2Invalid(it.toString())
        }.sum()
    }
    return result
}

fun run(input: String) {
    val part1Result = runPart1(input)
    println("part1 $part1Result")

    val part2Result = runPart2(input)
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