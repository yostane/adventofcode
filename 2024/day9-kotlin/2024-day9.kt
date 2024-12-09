///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day9-input.kt

fun computeDiskMap(input: String) = input.map(Char::digitToInt).windowed(2, 2, true)
    .mapIndexed { index, ints ->
        val fileBlocks = "$index".repeat(ints[0])
        val emptyBlocks = if (ints.size > 1) ".".repeat(ints[1]) else ""
        "$fileBlocks$emptyBlocks"
    }.reduce(String::plus)

fun compactDisk(diskMap: String): List<Char> {
    var lIndex = 0
    var rIndex = 0
    val dotCount = diskMap.count { it == '.' }
    val reversedDiskMap = diskMap.reversed()
    val digitsCharArray = Array(10) { it.digitToChar() }.toCharArray()
    var compactedDiskMap = diskMap.subSequence(0, diskMap.length - dotCount).toMutableList()
    while (compactedDiskMap.contains('.')) {
        lIndex = diskMap.indexOf('.', lIndex)
        rIndex = reversedDiskMap.indexOfAny(digitsCharArray, rIndex)
        compactedDiskMap[lIndex] = reversedDiskMap[rIndex]
        lIndex += 1
        rIndex += 1
    }
    return compactedDiskMap.toList()
}

fun run(input: String) {
    val diskMap = computeDiskMap(input)
//    println(diskMap)
    val compactedDiskMap = compactDisk(diskMap)
//    println(compactedDiskMap)
    val part1Result =
        compactedDiskMap.mapIndexed { index, ch -> index.toBigInteger() * ch.digitToInt().toBigInteger() }.sumOf { it }
    println("part1 $part1Result")

    val part2Result = 0
    println("part2 $part2Result")
}

fun main() {
//    println("Sample inputs")
//    sampleInputs.forEachIndexed { i, input ->
//        println("Sample input $i")
//        run(input)
//    }
    println("Puzzle input")
    run(input)
}