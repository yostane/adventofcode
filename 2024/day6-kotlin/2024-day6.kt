///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES input.kt

val guardPositions = mapOf(
    '^' to (-1 to 0),
    '>' to (0 to 1),
    'v' to (1 to 0),
    '<' to (0 to -1)
)

val orderedOrientations = listOf('^', '>', 'v', '<')

fun findGuard(map: MutableList<MutableList<Char>>) = map.mapIndexedNotNull { i, line ->
    val j = line.indexOfFirst { it in guardPositions.keys }
    if (j == -1) null else i to j
}.firstOrNull()

/**
 * @return true when we loop or false if we get out
 */
fun moveGuardOut(map: MutableList<MutableList<Char>>): Boolean {
    val originalPosition = findGuard(map)
    require(originalPosition != null)
    val originalGuard = map[originalPosition.first][originalPosition.second]
    var guardPosition = originalPosition
    val markedOrientations: MutableMap<Pair<Int, Int>, MutableSet<Char>> =
        mutableMapOf(originalPosition to mutableSetOf(originalGuard))
    while (true) {
        require(guardPosition != null)

//        println(guardPosition)
//        val tmp = map[guardPosition.first][guardPosition.second]
//        map[guardPosition.first][guardPosition.second] = '%'
//        println(map.joinToString("\n") { it.joinToString("") })
//        map[guardPosition.first][guardPosition.second] = tmp

        val guard = map[guardPosition.first][guardPosition.second]
        val delta = guardPositions[guard]
        require(delta != null)
        val nextPosition = guardPosition.first + delta.first to guardPosition.second + delta.second
        if (!map.indices.contains(nextPosition.first) || !map[nextPosition.first].indices.contains(nextPosition.second)) {
            return false
        }
        val nextPoint = map[nextPosition.first][nextPosition.second]
        if (nextPoint == '#') {
            val currentPositionIndex = orderedOrientations.indexOf(guard)
            val nextOrientation = orderedOrientations[(currentPositionIndex + 1) % orderedOrientations.size]
            map[guardPosition.first][guardPosition.second] = nextOrientation
        } else if (markedOrientations.getOrDefault(nextPosition, mutableSetOf()).contains(guard)) {
            return true
        } else {
            markedOrientations.getOrPut(nextPosition) { mutableSetOf(guard) }
            map[nextPosition.first][nextPosition.second] = guard
            guardPosition = nextPosition
        }
    }
}

fun run(input: String) {
    val patrolMap = input.lines().map { it.toMutableList() }.toMutableList()
    val originalGuardPosition = findGuard(patrolMap)
    require(originalGuardPosition != null)
    moveGuardOut(patrolMap)
    val part1Result = patrolMap.flatten().count { guardPositions.containsKey(it) }
    println("part1 $part1Result")

    val part2Result = patrolMap.mapIndexed { i, line ->
        line.filterIndexed { j, ch ->
            if (guardPositions.containsKey(ch) && originalGuardPosition != i to j) {
                val map = input.lines().map { it.toMutableList() }.toMutableList()
                map[i][j] = '#'
                println("$i, $j")
                moveGuardOut(map)
            } else {
                false
            }
        }.count()
    }.sum()

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