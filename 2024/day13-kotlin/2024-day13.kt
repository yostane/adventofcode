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
    val minimalCost: Int?
    private val maxPressPerButton = 100

    init {
        minimalCost = computeMinimalCost2()
    }

    private fun computeCost(aPressCount: Int, bPressCount: Int) = aPressCount * 3 + bPressCount

    private fun minNullable(minCost: Int?, newMinCost: Int?) =
        when {
            minCost != null && newMinCost == null -> minCost
            minCost == null && newMinCost != null -> newMinCost
            minCost != null && newMinCost != null -> min(minCost, newMinCost)
            else -> null
        }

    private fun findMinPresses(
        incrementPressMove: Vec2D,
        incrementPressCost: Int,
        otherPressMove: Vec2D,
        otherPressCost: Int
    ): MutableSet<GameAttempt> {
        var pressCount = 0L
        var currentLocation: Vec2D = 0 to 0
        val gameAttempts = mutableSetOf<GameAttempt>()
        while (pressCount < maxPressPerButton && currentLocation.first < target.first && currentLocation.second < target.second) {
            val remainingDistance = target - currentLocation
            if (remainingDistance.isMultipleOfWithSameFactor(otherPressMove)) {
                val otherPressCount = remainingDistance.first / otherPressMove.first
                if (otherPressCount <= 100) {
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

    private fun computeMinimalCost2(): Int? {
        val attempts = findMinPresses(aMove, 3, bMove, 1)
        attempts.addAll(findMinPresses(bMove, 1, aMove, 3))
        println(attempts.joinToString("\n"))
        return attempts.minOfOrNull { it.cost }
    }

    private fun computeMinimalCost(
        aPressCount: Int = 0,
        bPressCount: Int = 0,
        currentLocation: Vec2D = 0 to 0,
        pressedA: Boolean,
        currentMinCost: Int? = null
    ): Int? {
        if (aPressCount > maxPressPerButton || bPressCount > maxPressPerButton
            || currentLocation.first > target.first || currentLocation.second > target.second
        ) {
            return currentMinCost
        }
        if (currentLocation == target) {
            val cost = computeCost(aPressCount, bPressCount)
            return minNullable(currentMinCost, cost)
        }
        val remainingDistance = target - currentLocation
        if (pressedA) {
            if (remainingDistance.isMultipleOfWithSameFactor(bMove)) {
                val cost = computeCost(aPressCount, remainingDistance.first / bMove.first)
                println("a: $bPressCount, b: ${remainingDistance.first / aMove.first}, cost = $cost")
                return minNullable(currentMinCost, cost)
            }
            return computeMinimalCost(aPressCount + 1, bPressCount, currentLocation + aMove, true, currentMinCost)
        } else {
            if (remainingDistance.isMultipleOfWithSameFactor(aMove)) {
                val cost = computeCost(remainingDistance.first / aMove.first, bPressCount)
                println("a: ${remainingDistance.first / aMove.first}, b: $bPressCount, cost = $cost")
                return minNullable(currentMinCost, cost)
            }
            return computeMinimalCost(aPressCount, bPressCount + 1, currentLocation + bMove, false, currentMinCost)
        }
    }

    override fun toString(): String {
        return "Machine(minimalCost=$minimalCost, target=$target, bMove=$bMove, aMove=$aMove)"
    }
}

fun Vec2D.isInBox(lineCount: Int, columnCount: Int) =
    this.first in 0..<lineCount && this.second in 0..<columnCount

fun parseButtonLine(line: String): Vec2D {
    val x = line.substringAfter("X+").substringBefore(", Y+").toInt()
    val y = line.substringAfter(", Y+").toInt()
    return x to y
}

fun parsePrizeLine(line: String): Vec2D {
    val x = line.substringAfter("X=").substringBefore(", Y=").toInt()
    val y = line.substringAfter(", Y=").toInt()
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

    val part2Result = 0
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