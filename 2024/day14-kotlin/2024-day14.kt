///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day14-input.kt
//SOURCES Vec2D.kt

data class Robot(val initialPosition: Vec2D, val movement: Vec2D, val bounds: Vec2D) {
    fun move(times: Int): Vec2D {
        val destination = initialPosition + movement * times
        val moduloDestination = destination % bounds
        return moduloDestination.wrapTo(bounds)
    }
}

fun run(input: String) {
    val lines = input.lines()
    val width = lines[0].substringBefore(" ").toInt()
    val height = lines[0].substringAfter(" ").toInt()
    val halfWidth = width / 2
    val halfHeight = height / 2
    val robots = lines.subList(1, lines.size).map {
        val data = it.split(" ")
        val x = data[0].substringBefore(",").substringAfter("=").toInt()
        val y = data[0].substringAfter(",").toInt()
        val dx = data[1].substringBefore(",").substringAfter("=").toInt()
        val dy = data[1].substringAfter(",").toInt()
        Robot(x to y, dx to dy, width to height)
    }

    val quadrants = MutableList(4) { 0 }
    robots.forEach {
        val destination = it.move(100)
        println("$it - destination $destination")
        if (destination.first == halfWidth || destination.second == halfHeight) {
            return@forEach
        }
        val quadrant = when {
            destination.first < halfWidth && destination.second < halfHeight -> 0
            destination.first < halfWidth -> 1
            destination.second < halfHeight -> 2
            else -> 3
        }
        quadrants[quadrant] += 1
    }
    println(quadrants.joinToString(", "))
    val part1Result = quadrants.reduce { acc, item -> acc * item }
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