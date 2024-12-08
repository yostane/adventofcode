///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day8-input.kt

typealias Position = Pair<Int, Int>

operator fun Position.minus(rightPosition: Position) =
    this.first - rightPosition.first to this.second - rightPosition.second

operator fun Position.plus(rightPosition: Position) =
    this.first + rightPosition.first to this.second + rightPosition.second

operator fun Position.unaryMinus() =
    -this.first to -this.second

fun Position.isInBox(lineCount: Int, columnCount: Int) =
    this.first in 0..<lineCount && this.second in 0..<columnCount


fun findLettersLocations(lines: List<String>): Map<Char, List<Position>> {
    val charPositions: MutableMap<Char, MutableList<Position>> = mutableMapOf()
    for (i in lines.indices) {
        val line = lines[i]
        for (j in line.indices) {
            val item = line[j]
            if (item != '.') {
                charPositions.getOrPut(item) { mutableListOf() }.add(i to j)
            }
        }
    }
    return charPositions.toMap()
}

fun countAntidotes(charPositions: Map<Char, List<Position>>, lineCount: Int, columnCount: Int): Pair<Int, Int> {
    val debugMap =
        generateSequence { generateSequence { '.' }.take(columnCount).toMutableList() }.take(lineCount).toMutableList()
    val debugLineMap =
        generateSequence { generateSequence { '.' }.take(columnCount).toMutableList() }.take(lineCount).toMutableList()
    val antidotePositions = mutableSetOf<Position>()
    val lineAntidotePositions = mutableSetOf<Position>()
    charPositions.forEach {
        val positions = it.value
        if (positions.size > 1) {
            lineAntidotePositions.addAll(positions)
        }
        var count = 0
        for (i in 0..<positions.lastIndex) {
            val position = positions[i]
            val otherPositions = positions.drop(i + 1)
//            println("Checking letter ${it.key} at $position with $otherPositions")
            for (otherPosition in otherPositions) {
                val delta = position - otherPosition

                fun checkAndAdd(p: Position) {
//                    println("Checking $p")
                    if (p.isInBox(lineCount, columnCount)) {
                        antidotePositions.add(p)
                        debugMap[p.first][p.second] = '#'
//                        println("Adding $p")
                    }
                }
                checkAndAdd(position + delta)
                checkAndAdd(otherPosition - delta)

                fun checkLine(originalPosition: Position, delta: Position) {
                    var p = originalPosition + delta
                    while (p.isInBox(lineCount, columnCount)) {
                        lineAntidotePositions.add(p)
                        debugLineMap[p.first][p.second] = '#'
                        p += delta
                    }
                }
                checkLine(position, delta)
                checkLine(otherPosition, -delta)
            }
        }
    }
//    println("Result")
//    debugMap.forEach { println(it.joinToString(" ")) }
    return antidotePositions.size to lineAntidotePositions.size
}

fun run(input: String) {
    val lines = input.lines()
    val charPositions = findLettersLocations(lines)
    val (part1Result, part2Result) = countAntidotes(charPositions, lines.size, lines[0].length)
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