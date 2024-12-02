///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES input.kt

import kotlin.math.abs
import kotlin.time.Duration.Companion.seconds

fun isReportSafe(reportLevels: List<Int>): Boolean {
    val differences = reportLevels.windowed(2).map { it[1] - it[0] }
    val areDifferencesInRange = differences.all { abs(it) >= 1 && abs(it) <= 3 }
    val areOnlyIncreasing = differences.all { it >= 0 }
    val areOnlyDecreases = differences.all { it <= 0 }
    return areDifferencesInRange && (areOnlyIncreasing || areOnlyDecreases)
}

fun isReportSafeWithDampener(reportLevels: List<Int>) =
    (0..<(reportLevels.size)).map {
        reportLevels.filterIndexed { index, item -> index != it }
    }.any { isReportSafe(it) }

fun run(input: String) {
    val lines = input.split("\n")
    val reports = lines.map { it.split(" ").map { it.toInt() } }
    val part1Result = reports.count(::isReportSafe)
    println("part1 $part1Result")
    val part2Result = +part1Result + reports.filter { !isReportSafe(it) }.filter(::isReportSafeWithDampener).size
    println("part2 $part2Result")
}

fun main() {
    println("Sample input")
    run(testInput)
    println("Puzzle input")
    run(input)
}