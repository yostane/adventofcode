import kotlin.math.min

///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day13-input.kt

typealias Vec2D = Pair<Long, Long>

operator fun Vec2D.minus(rightPosition: Vec2D) =
    this.first - rightPosition.first to this.second - rightPosition.second

operator fun Vec2D.plus(rightPosition: Vec2D) =
    this.first + rightPosition.first to this.second + rightPosition.second

operator fun Vec2D.unaryMinus() =
    -this.first to -this.second

operator fun Vec2D.times(vec2D: Vec2D) =
    this.first * vec2D.first to this.second * vec2D.second

operator fun Vec2D.times(op2: Int) =
    this.first * op2 to this.second * op2

fun Vec2D.isMultipleOfWithSameFactor(vec2D: Vec2D) =
    this.first % vec2D.first == 0L && this.second % vec2D.second == 0L && this.first / vec2D.first == this.second / vec2D.second

data class GameAttempt(val aPresses: Long, val bPresses: Long, val cost: Long)

data class Machine(val aMove: Vec2D, val bMove: Vec2D, val target: Vec2D) {
    val minimalCost: Long?
    private val maxPressPerButton = 100

    init {
        minimalCost = computeMinimalCost2()
    }

    private fun findMinPresses(
        incrementPressMove: Vec2D,
        incrementPressCost: Int,
        otherPressMove: Vec2D,
        otherPressCost: Int,
    ): MutableSet<GameAttempt> {
        var pressCount = 0L
        var currentLocation: Vec2D = 0L to 0L
        val gameAttempts = mutableSetOf<GameAttempt>()
        while ((target.first > 10000000000000 || pressCount < maxPressPerButton) && currentLocation.first < target.first && currentLocation.second < target.second) {
            val remainingDistance = target - currentLocation
            if (remainingDistance.isMultipleOfWithSameFactor(otherPressMove)) {
                val otherPressCount = remainingDistance.first / otherPressMove.first
                if (target.first > 10000000000000L || otherPressCount <= 100) {
                    val cost = pressCount * incrementPressCost + otherPressCost * otherPressCount
                    val gameAttempt = GameAttempt(pressCount, otherPressCount, cost)
                    gameAttempts.add(gameAttempt)
                }
            }
            pressCount += 1
            currentLocation += incrementPressMove
        }
        return gameAttempts
    }

    private fun computeMinimalCost2(): Long? {
        val attempts = findMinPresses(aMove, 3, bMove, 1)
        attempts.addAll(findMinPresses(bMove, 1, aMove, 3))
        println(attempts.joinToString("\n"))
        return attempts.minOfOrNull { it.cost }
    }

    override fun toString(): String {
        return "Machine(minimalCost=$minimalCost, target=$target, bMove=$bMove, aMove=$aMove)"
    }
}

fun Vec2D.isInBox(lineCount: Int, columnCount: Int) =
    this.first in 0..<lineCount && this.second in 0..<columnCount

fun parseButtonLine(line: String): Vec2D {
    val x = line.substringAfter("X+").substringBefore(", Y+").toLong()
    val y = line.substringAfter(", Y+").toLong()
    return x to y
}

fun parsePrizeLine(line: String): Vec2D {
    val x = line.substringAfter("X=").substringBefore(", Y=").toLong()
    val y = line.substringAfter(", Y=").toLong()
    return x to y
}

fun run(input: String) {
    val machinesLines = input.split("\n\n")
    val machines = machinesLines.map {
        val lines = it.lines()
        require(lines.size == 3)
        Machine(
            parseButtonLine(lines[0]),
            parseButtonLine(lines[1]),
            parsePrizeLine(lines[2])
        )
    }.apply { println(joinToString("\n")) }
    val part1Result = machines.sumOf { it.minimalCost ?: 0 }
    println("part1 $part1Result")

    val machines2 = machines.map {
        Machine(it.aMove, it.bMove, it.target.first + 10000000000000L to it.target.second + 10000000000000L)
    }
    val part2Result = machines2.sumOf { it.minimalCost ?: 0L }
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