///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day11-input.kt

fun blink(stones: List<String>) =
    stones.flatMap {
        val result = when {
            it == "0" -> listOf("1")
            it.length % 2 == 0 -> listOf(
                it.substring(0, it.length / 2).toLong().toString(),
                it.substring(it.length / 2).toLong().toString()
            )

            else -> listOf((it.toLong() * 2024L).toString())
        }
        result
    }

fun countStonesRecursive(stone: String, currentBlinkCount: Int, maxBlinkCount: Int): Int {
    if (currentBlinkCount == maxBlinkCount) {
        return 1
    }
    return when {
        stone == "0" -> countStonesRecursive("1", currentBlinkCount + 1, maxBlinkCount)
        stone.length % 2 == 0 -> {
            val p1 = stone.substring(0, stone.length / 2).toLong().toString()
            val h1 = countStonesRecursive(p1, currentBlinkCount + 1, maxBlinkCount)
            val p2 = stone.substring(stone.length / 2).toLong().toString()
            val h2 = countStonesRecursive(p2, currentBlinkCount + 1, maxBlinkCount)
            h1 + h2
        }

        else -> countStonesRecursive((stone.toLong() * 2024L).toString(), currentBlinkCount + 1, maxBlinkCount)
    }
}

fun countStonesRecursiveOptimized(stone: String, currentBlinkCount: Int, maxBlinkCount: Int): Int {
    if (currentBlinkCount == maxBlinkCount) {
        return 1
    }
    return when {
        stone == "0" -> countStonesRecursive("1", currentBlinkCount + 1, maxBlinkCount)
        stone.length % 2 == 0 -> {
            val p1 = stone.substring(0, stone.length / 2).toLong().toString()
            val h1 = countStonesRecursive(p1, currentBlinkCount + 1, maxBlinkCount)
            val p2 = stone.substring(stone.length / 2).toLong().toString()
            val h2 = countStonesRecursive(p2, currentBlinkCount + 1, maxBlinkCount)
            h1 + h2
        }

        else -> countStonesRecursive((stone.toLong() * 2024L).toString(), currentBlinkCount + 1, maxBlinkCount)
    }
}

fun run(input: String) {
    val intialStones = input.split(" ")
    var stones = intialStones
    for (i in 0..<25) {
        stones = blink(stones)
//        println("After blink $i\n${stones.joinToString(" ")}")
    }
    val part1Result = stones.size
    val part1ResultMethod2 = intialStones.sumOf { countStonesRecursive(it, 0, 25) }
    println("part1 $part1Result - $part1ResultMethod2")

    val part2ResultMethod2 = stones.sumOf { countStonesRecursive(it, 25, 75) }
    println("part2 $part2ResultMethod2")
//    for (i in 25..<75) {
//        stones = blink(stones)
////        println("After blink $i\n${stones.joinToString(" ")}")
//    }
//    val part2Result = stones.size
//    println("part2 $part2Result")
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