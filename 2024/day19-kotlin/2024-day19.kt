///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day19-input.kt


fun countPossibleMatches(design: String, patterns: List<String>, cache: MutableMap<String, Long>): Long {
    val cached = cache[design]
    if (cached != null) return cached
    val result = patterns.filter { design.startsWith(it) }.sumOf {
        if (design == it) 1 else countPossibleMatches(design.substring(it.length), patterns, cache)
    }
    cache[design] = result
    return result
}

fun run(input: String) {
    val (patternsPart, towelPart) = input.split("\n\n")
    val patterns = patternsPart.split(", ").sortedByDescending { it.length }
    val patternRegex = "(${patterns.joinToString("|")})+".toRegex()
    val part1Result = towelPart.lineSequence().count { patternRegex matches it }
    println("part1 $part1Result")

    val part2Result = towelPart.lineSequence().sumOf { countPossibleMatches(it, patterns, mutableMapOf()) }
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