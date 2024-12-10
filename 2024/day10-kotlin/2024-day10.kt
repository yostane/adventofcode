///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day10-input.kt

typealias Vec2D = Pair<Int, Int>

operator fun Vec2D.minus(rightPosition: Vec2D) =
    this.first - rightPosition.first to this.second - rightPosition.second

operator fun Vec2D.plus(rightPosition: Vec2D) =
    this.first + rightPosition.first to this.second + rightPosition.second

operator fun Vec2D.unaryMinus() =
    -this.first to -this.second

fun Vec2D.isInBox(lineCount: Int, columnCount: Int) =
    this.first in 0..<lineCount && this.second in 0..<columnCount

fun countTrails(map: List<List<Int>>, currentVec2D: Vec2D, sourceDelta: Vec2D, reachedSummits: MutableSet<Vec2D>): Int {
    if (!currentVec2D.isInBox(map.size, map[0].size)) {
        return 0
    }
    if (map[currentVec2D.first][currentVec2D.second] == -1) {
        return 0
    }
    val (sourceI, sourceJ) = currentVec2D - sourceDelta
    if (sourceDelta != 0 to 0 && map[currentVec2D.first][currentVec2D.second] - map[sourceI][sourceJ] != 1) {
        return 0
    }
    if (map[currentVec2D.first][currentVec2D.second] == 9) {
        reachedSummits.add(currentVec2D)
        return 1
    }
    val deltas = listOf(1 to 0, 0 to 1, -1 to 0, 0 to -1).filter { it != -sourceDelta }
    val sum = deltas.sumOf {
        countTrails(map, currentVec2D + it, it, reachedSummits)
    }
    return sum
}

fun run(input: String) {
    val map = input.lines().map { it.map { if (it == '.') -1 else it.digitToInt() } }
    val trailHeads = map.flatMapIndexed { i, line ->
        line.mapIndexedNotNull { j, height -> if (height == 0) i to j else null }
    }
    val (part1Result, part2Result) = trailHeads.map {
        val reachedSummits = mutableSetOf<Vec2D>()
        val count = countTrails(map, it, 0 to 0, reachedSummits)
        reachedSummits.size to count
    }.reduce { acc, cur -> acc + cur }
    println("part1 $part1Result")

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