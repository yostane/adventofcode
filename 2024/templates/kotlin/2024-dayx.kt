///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES input.kt

fun run(input: String) {
    val part1Result = 0
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