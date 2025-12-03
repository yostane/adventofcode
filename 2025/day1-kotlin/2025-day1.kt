import kotlin.math.abs

///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.2.21
//SOURCES 2025-day1-input.kt

data class Rotation(val direction: Char, val value: Int)

fun runPart1(input: String): Int {
    val tickCounts = input.lines().map { line ->
        val direction = line[0]
        val tickCount = line.substring(1).toInt() % 100
        if (direction == 'L') -tickCount else tickCount
    }
    var currentPosition = 50
    var zeroCount = 0
    for (tickCount in tickCounts) {
        currentPosition = (currentPosition + tickCount) % 100
        while (currentPosition < 0) {
            currentPosition += 100
        }
        zeroCount += if (currentPosition == 0) 1 else 0
    }
    return zeroCount
}

fun runPart2(input: String): Int {
    val tickCounts = input.lines().map { line ->
        val direction = line[0]
        val tickCount = line.substring(1).toInt()
        if (direction == 'L') -tickCount else tickCount
    }
    var currentPosition = 50
    var zeroCount = 0
    for (tickCount in tickCounts) {
        val originalPosition = currentPosition
        currentPosition = (currentPosition + tickCount)
        if (currentPosition > 0) {
            zeroCount += currentPosition / 100
        } else if (currentPosition < 0) {
            zeroCount += abs(currentPosition) / 100
        }

        while (!(currentPosition in 0..99)) {
            val factor = if (currentPosition < 0) 1 else -1
            // println("Found overflow ${currentPosition}")
            currentPosition += factor * 100
        }
        zeroCount += if (currentPosition == 0) 1 else 0
        // println("Current pos ${currentPosition}. Zerocount ${zeroCount}")
    }
    return zeroCount
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