///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES input.kt

// source: https://gist.github.com/kiwiandroiddev/fef957a69f91fa64a46790977d98862b
fun <T, U> cartesianProduct(c1: Collection<T>, c2: Collection<U>): List<Pair<T, U>> {
    return c1.flatMap { lhsElem -> c2.map { rhsElem -> lhsElem to rhsElem } }
}

fun isXmasAtPositionAndDirection(lines: List<String>, i: Int, j: Int, di: Int, dj: Int): Boolean {
    val word = "XMAS"
    val indices = generateSequence(i to j) { it.first + di to it.second + dj }.take(word.length)
    return indices.zip(word.asSequence()).all { (coordinates, char) ->
        coordinates.first >= 0 && coordinates.first < lines.size
                && coordinates.second >= 0 && coordinates.second < lines[coordinates.first].length
                && lines[coordinates.first][coordinates.second] == char
    }
}

fun isCrossMasAtPosition(lines: List<String>, i: Int, j: Int): Boolean {
    val word = "MAS"
    val firstCrossPart = generateSequence(i-1 to j-1) { it.first + 1 to it.second + 1 }.take(3)
    val secondCrossPart = generateSequence(i-1 to j+1) { it.first + 1 to it.second - 1 }.take(3)
    if (firstCrossPart.any { !(0..<lines.size).contains(it.first) || !(0..<(lines[it.first].length)).contains(it.second) }
        || secondCrossPart.any { !(0..<lines.size).contains(it.first) || !(0..<(lines[it.first].length)).contains(it.second) }) {
        return false
    }
    val firstCross = firstCrossPart.map { lines[it.first][it.second]  }.joinToString("")
    val secondCross = secondCrossPart.map { lines[it.first][it.second]  }.joinToString("")
    return (firstCross == word || firstCross == word.reversed()) && (secondCross == word || secondCross == word.reversed())
}

fun run(input: String) {
    val lines = input.split("\n")
    val part1Result = lines.mapIndexed { i, line ->
        line.mapIndexed { j, char ->
            cartesianProduct((-1..1).toList(),(-1..1).toList()).filter { it != 0 to 0 }.count {
                isXmasAtPositionAndDirection(lines, i, j, it.first, it.second)
            }
        }.sum()
    }.sum()
    println("part1 $part1Result")

    val part2Result = lines.mapIndexed { i, line ->
        line.filterIndexed { j, char ->
            isCrossMasAtPosition(lines, i, j)
        }.count()
    }.sum()
    println("part2 $part2Result")
}

fun main() {
    println("Sample input")
    run(testInput)
    println("Puzzle input")
    run(input)
}