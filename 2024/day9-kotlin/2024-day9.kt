///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day9-input.kt

fun computeDiskMap(input: String): List<Int> = input.map(Char::digitToInt).windowed(2, 2, true)
    .flatMapIndexed { index, ints ->
        val result = mutableListOf<Int>()
        result.addAll(List(ints[0]) { index })
        result.addAll(if (ints.size > 1) List(ints[1]) { -1 } else emptyList())
        result
    }

fun compactDiskWhole(diskMap: List<Int>): List<Int> {
    var rIndex = diskMap.lastIndex
    var compactedDisk = diskMap.toMutableList()
    while (rIndex >= 0) {
        val firstRIndex = compactedDisk.indexOfFirst { it == compactedDisk[rIndex] }
        val count = rIndex - firstRIndex + 1
        for (i in 0..(diskMap.lastIndex - count)) {
            val subList = compactedDisk.subList(i, i + count)
            if (subList.all { it == -1 }) {
                compactedDisk.subList(i, i + count).fill(diskMap[rIndex])
                compactedDisk.subList(firstRIndex, rIndex).fill(-1)
                rIndex = firstRIndex
                do {
                    rIndex -= 1
                } while (rIndex >= 0 && compactedDisk[rIndex] == -1)
                break
            }
        }
    }
    return compactedDisk
}

fun compactDisk(diskMap: List<Int>): List<Int> {
    var rIndex = diskMap.lastIndex
    var compactedDisk = mutableListOf<Int>()
    val dotCount = diskMap.count { it == -1 }
    while (compactedDisk.size < diskMap.size - dotCount) {
        val lIndex = compactedDisk.size
        if (diskMap[lIndex] != -1) {
            compactedDisk.add(diskMap[lIndex])
        } else {
            compactedDisk.add(diskMap[rIndex])
            do {
                rIndex -= 1
            } while (diskMap[rIndex] == -1)
        }
    }
    return compactedDisk
}

fun run(input: String) {
    val diskMap = computeDiskMap(input)
//    println(diskMap.joinToString(","))
    val compactedDiskMap = compactDisk(diskMap)
//    println("Compacted Disk")
    println(compactedDiskMap.joinToString(","))
    val part1Result =
        compactedDiskMap.mapIndexed { index, ch -> index.toBigInteger() * ch.toBigInteger() }.sumOf { it }
    println("part1 $part1Result")

    val compactedWhole = compactDiskWhole(diskMap)
    println("Compacted Whole files")
    println(compactedWhole.joinToString(","))
    val part2Result = compactedWhole.mapIndexed { index, ch -> index.toBigInteger() * ch.toBigInteger() }.sumOf { it }
    println("part2 $part2Result")
}

fun main() {
    println("Sample inputs")
    sampleInputs.forEachIndexed { i, input ->
        println("Sample input $i")
        run(input)
    }
//    println("Puzzle input")
//    run(input)
}