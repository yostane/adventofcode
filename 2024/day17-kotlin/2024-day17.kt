///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day17-input.kt

import kotlin.math.pow

typealias Instruction = Pair<Int, Int>

class Program(var a: Long, var b: Long, var c: Long, val instructions: List<Int>) {
    var outputs = mutableListOf<Int>()
    var ip = 0

    fun getComboOperand(operand: Int) =
        when (operand) {
            in 0..3 -> operand.toLong()
            4 -> a
            5 -> b
            6 -> c
            else -> throw Error("invalid combo operand")
        }

    fun run(opcode: Int, operand: Int) {
        when (opcode) {
            0 -> a = a / 2.0.pow(getComboOperand(operand).toDouble()).toLong()
            1 -> b = b.xor(operand.toLong())
            2 -> b = getComboOperand(operand) % 8
            3 -> {
                if (a != 0L) ip = operand
                return
            }

            4 -> b = b.xor(c)
            5 -> outputs.add((getComboOperand(operand) % 8).toInt())
            6 -> b = a / 2.0.pow(getComboOperand(operand).toDouble()).toLong()
            7 -> c = a / 2.0.pow(getComboOperand(operand).toDouble()).toLong()
        }
        ip += 2
    }

    fun run() {
        while (ip < instructions.lastIndex) {
            run(instructions[ip], instructions[ip + 1])
        }
    }
}

fun run(input: String) {
    val lines = input.lines()
    val a = lines[0].substringAfter("Register A: ").toBigInteger()
    val b = lines[1].substringAfter("Register B: ").toBigInteger()
    val c = lines[2].substringAfter("Register C: ").toBigInteger()
    val instructions = lines[4].split("""\d,\d""".toRegex())
        .map {
            val opcode = it.substringBefore(",").toUByte()
            val operand = it.substringAfter(",").toUByte()
            opcode to operand
        }
    val program = Program(a, b, c, instructions)
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