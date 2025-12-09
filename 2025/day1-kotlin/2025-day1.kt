///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.2.21
//SOURCES 2025-day1-input.kt

import kotlin.math.abs

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
        currentPosition += tickCount
        zeroCount += if (currentPosition == 0) 1 else abs(currentPosition / 100)
        currentPosition %= 100
        zeroCount += if (tickCount <= -100 && currentPosition == 0 && originalPosition != 0) 1 else 0
        if (currentPosition < 0) {
            currentPosition += 100
            zeroCount += if (originalPosition != 0) 1 else 0
        }
        print("[o=${originalPosition}, t=${tickCount}, c=${currentPosition}, z=$zeroCount] ")
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