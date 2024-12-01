///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES input.kt

import kotlin.math.abs

fun run(input: String) {
    val lines = input.split("\n")
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()
    lines.map {
        val ints = it.split("   ")
        leftList.add(ints[0].toInt())
        rightList.add(ints[1].toInt())
    }
    val sortedLeftList = leftList.sorted()
    val sortedRightList = rightList.sorted()

    println("Part1 ${sortedLeftList.zip(sortedRightList).sumOf { abs(it.first - it.second) }}")
    /*
    val rightGrouped = sortedRightList.groupBy{ it }

    val similarityScore = sortedLeftList.distinct().sumOf { i ->
        i * rightGrouped.getOrDefault(i, emptyList()).size
    }
    */
    val similarityScore = sortedLeftList.sumOf { i ->
        i * sortedRightList.count { it == i }
    }
    println("Part2 $similarityScore")
}

fun main() {
    run(testInput)
    run(input)
}