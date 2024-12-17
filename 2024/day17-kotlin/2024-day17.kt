///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day17-input.kt

import kotlin.math.pow

typealias Instruction = Pair<Int, Int>

typealias  CacheEntry = Int

data class CachedComputer(var a: Long, var b: Long, var c: Long, val existingOutputs: List<Int>, val ip: Int)

class Computer(var a: Long, var b: Long, var c: Long, val instructions: List<Int>, val maxOutputSize: Int?) {
    companion object {
        val cache = mutableMapOf<CacheEntry, Int>()
    }

    var outputHashCode: Int? = null

    var outputs = mutableListOf<Int>()
    var ip = 0
    val computersToCache = mutableListOf<CacheEntry>()
    fun putAsideForCache(cacheKey: CacheEntry){
        if (outputs.isNotEmpty()) return
        computersToCache.add(cacheKey)
    }
    fun getCacheKey() = "$a,$b,$c,$ip,${outputs.hashCode()}".hashCode()

    fun updateCache() {
        val hash = outputs.hashCode()
        if (outputHashCode == null){
            outputHashCode = hash
        }
        computersToCache.forEach { cache[it] = hash }
    }

    private fun getComboOperand(operand: Int) =
        when (operand) {
            in 0..3 -> operand.toLong()
            4 -> a
            5 -> b
            6 -> c
            else -> throw Error("invalid combo operand")
        }

    private fun runInstruction(opcode: Int, operand: Int) {
        when (opcode) {
            0 -> a = a / 2.0.pow(getComboOperand(operand).toDouble()).toLong()
            1 -> b = b.xor(operand.toLong())
            2 -> b = getComboOperand(operand) % 8
            3 -> if (a != 0L) {
                ip = operand
                return
            }

            4 -> b = b.xor(c)
            5 -> outputs.add((getComboOperand(operand) % 8).toInt())
            6 -> b = a / 2.0.pow(getComboOperand(operand).toDouble()).toLong()
            7 -> c = a / 2.0.pow(getComboOperand(operand).toDouble()).toLong()
        }
        ip += 2
    }

    fun runProgram() {
        while (ip < instructions.lastIndex) {
            val cacheKey = getCacheKey()
            val cachedOutputs = cache[cacheKey]
            if (cachedOutputs != null){
                outputHashCode = cachedOutputs
                updateCache()
                return
            }
            putAsideForCache(cacheKey)
            runInstruction(instructions[ip], instructions[ip + 1])
            if (maxOutputSize != null && outputs.size > maxOutputSize + 2) {
//                outputs.clear()
                updateCache()
                return
            }
        }
        updateCache()
    }

    fun getOutputAsString() = outputs.joinToString(",")
}

fun runProgram(input: String) {
    val lines = input.lines()
    val a = lines[0].substringAfter("Register A: ").toLong()
    val b = lines[1].substringAfter("Register B: ").toLong()
    val c = lines[2].substringAfter("Register C: ").toLong()
    val program = lines[4].substringAfter("Program: ")
    val instructions = program.split(",").map(String::toInt)
    val computer = Computer(a, b, c, instructions, null)
    computer.runProgram()

    var outputHashCode = 0

    println("part1 $program, ${computer.getOutputAsString()}")
    val hashCode = instructions.hashCode()
    var x = 35000017669400L
    do {
        x += 1
        val c = Computer(x, b, c, instructions, instructions.size)
        c.runProgram()
        val outputHashCode = c.outputHashCode
        println("a: $x - hash: $outputHashCode. TargetHash: $hashCode")
    } while (outputHashCode != hashCode)
    val part2Result = x
    println("part2 $part2Result")
}

fun main() {
//    println("Sample inputs")
//    sampleInputs.forEachIndexed { i, input ->
//        println("Sample input $i")
//        runProgram(input)
//    }
    println("Puzzle input")
    runProgram(input)
}