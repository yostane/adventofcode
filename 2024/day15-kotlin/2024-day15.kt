///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day15-input.kt

open class Robot(val map: Map, val moves: String) {
    companion object {
        const val WALL = '#'
        const val BOX = 'O'
        const val BOX_LEFT = '['
        const val BOX_RIGHT = ']'
        const val FREE = '.'
        const val ROBOT = '@'
    }

    protected val shouldLog = false
    protected var position: Vec2D
    protected val directions = mapOf('>' to (0 to 1), '<' to (0 to -1), 'v' to (1 to 0), '^' to (-1 to 0))

    protected fun findRobotInMap(): Vec2D {
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] == ROBOT) {
                    return i to j
                }
            }
        }
        throw Error("Robot not found")
    }

    private fun log(text: String) {
        if (!shouldLog) return
        println(text)
    }

    init {
        position = findRobotInMap()
        log("Robot found at $position")
        doAllMoves()
    }

    protected fun isWall(vec2D: Vec2D) = map[vec2D] == WALL
    protected open fun isBox(vec2D: Vec2D) = map[vec2D] == BOX
    protected fun isFreeSpace(vec2D: Vec2D) = map[vec2D] == FREE

    protected open fun move(direction: Vec2D): Boolean {
        val nextPosition = direction + position
        if (isFreeSpace(nextPosition)) {
            map[position] = FREE
            map[nextPosition] = ROBOT
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
            map[newPosition] = BOX
            map[nextPosition] = ROBOT
            map[position] = FREE
            position = nextPosition
            return true
        }
        throw Error("No wall or free space found. Position: $position, direction: $direction")
    }

    protected fun doAllMoves() {
        log(map.asString())
        for (move in moves) {
            val direction = directions[move]
            require(direction != null)
            move(direction)
            log("$position, moving with $direction from move $move")
            log(map.asString())
        }
    }

    fun sumOfBoxGpsCoordinates(): Long {
        var sum = 0L
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (isBox(i to j)) {
                    val coordinates = 100L * i + j
                    log("($i,$j) -> $coordinates")
                    sum += coordinates
                }
            }
        }
        return sum
    }
}

class WideAreaRobot(map: Map, moves: String) : Robot(map, moves) {
    override fun isBox(vec2D: Vec2D) = map[vec2D] in listOf(BOX_LEFT, BOX_RIGHT)

    override fun move(direction: Vec2D): Boolean {
        val nextPosition = direction + position
        if (isFreeSpace(nextPosition)) {
            map[position] = FREE
            map[nextPosition] = ROBOT
            position = nextPosition
            return true
        }
        if (direction.first != 0) {
            var newPosition = nextPosition
            while (isBox(newPosition)) {
                newPosition += direction
            }
            if (isWall(newPosition)) {
                return false
            }
            if (isFreeSpace(newPosition)) {
                // TODO: update horizontal push
                map[newPosition] = BOX
                map[nextPosition] = ROBOT
                map[position] = FREE
                position = nextPosition
                return true
            }
        } else {
            //TODO: handle vertical shift
        }
        throw Error("No wall or free space found. Position: $position, direction: $direction")
    }
}

fun run(input: String): Pair<Long, Long> {
    val inputParts = input.split("\n\n")
    val map = inputParts[0].lineSequence().map { it.toMutableList() }.toList()
    val moves = inputParts[1].lineSequence().joinToString("")
    val robot = Robot(map, moves)
    val part1Result = robot.sumOfBoxGpsCoordinates()
    println("part1 $part1Result")

    val wideMap = mutableListOf<MutableList<Char>>()
    for (i in map.indices) {
        for (j in map.indices) {
            val line = mutableListOf<Char>()
            when (map[i][j]) {
                Robot.BOX -> line.addAll(listOf(Robot.BOX_LEFT, Robot.BOX_RIGHT))
                Robot.WALL -> line.addAll(listOf(Robot.WALL, Robot.WALL))
                Robot.FREE -> line.addAll(listOf(Robot.FREE, Robot.FREE))
                else -> line.addAll(listOf(Robot.ROBOT, Robot.FREE))
            }
        }
    }
    val wideAreaRobot = WideAreaRobot(wideMap, moves)
    val part2Result = wideAreaRobot.sumOfBoxGpsCoordinates()
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