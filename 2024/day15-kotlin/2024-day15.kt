///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day15-input.kt

open class Robot(val map: Map, val moves: String) {
    private val wall = '#'
    private val box = 'O'
    private val free = '.'
    private val robot = '@'
    var position: Vec2D
    val directions = mapOf('>' to (0 to 1), '<' to (0 to -1), 'v' to (1 to 0), '^' to (-1 to 0))

    fun findRobotInMap(): Vec2D {
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] == robot) {
                    return i to j
                }
            }
        }
        throw Error("Robot not found")
    }

    init {
        position = findRobotInMap()
        println("Robot found at $position")
        doAllMoves()
    }

    fun isWall(vec2D: Vec2D) = map[vec2D] == wall
    fun isBox(vec2D: Vec2D) = map[vec2D] == box
    fun isFreeSpace(vec2D: Vec2D) = map[vec2D] == free

    private fun move(direction: Vec2D): Boolean {
        val nextPosition = direction + position
        if (isFreeSpace(nextPosition)) {
            map[position] = free
            map[nextPosition] = robot
            position = nextPosition
            return true
        }
        var newPosition = nextPosition
        while (isBox(newPosition)) {
            newPosition += direction
        }
        if (isWall(newPosition)) {
            return false
        }
        if (isFreeSpace(newPosition)) {
            map[newPosition] = box
            map[nextPosition] = robot
            map[position] = free
            position = nextPosition
            return true
        }
        throw Error("No wall or free space found. Position: $position, direction: $direction")
    }

    fun doAllMoves() {
        println(map.asString())
        for (move in moves) {
            val direction = directions[move]
            require(direction != null)
            move(direction)
            println("$position, moving with $direction from move $move")
            println(map.asString())
        }
    }

    fun sumOfBoxGpsCoordinates(): Long {
        var sum = 0L
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (isBox(i to j)) {
                    val coordinates = 100L * i + j
                    println("($i,$j) -> $coordinates")
                    sum += coordinates
                }
            }
        }
        return sum
    }
}

fun run(input: String): Pair<Long, Long> {
    val inputParts = input.split("\n\n")
    val map = inputParts[0].lineSequence().map { it.toMutableList() }.toList()
    val moves = inputParts[1].lineSequence().joinToString("")
    val robot = Robot(map, moves)
    val part1Result = robot.sumOfBoxGpsCoordinates()
    println("part1 $part1Result")

    val part2Result = 0L
    println("part2 $part2Result")
    return part1Result to part2Result
}

fun main() {
    println("Sample inputs")
    sampleInputs.mapIndexed { i, input ->
        println("Sample input $i")
        run(input)
    }.forEachIndexed { i, results -> println("Sample $i -> $results") }
    println("Puzzle input")
    run(input)
}