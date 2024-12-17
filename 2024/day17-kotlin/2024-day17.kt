///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day17-input.kt

import kotlin.math.pow

typealias Instruction = Pair<Int, Int>

class Computer(var a: Long, var b: Long, var c: Long, val instructions: List<Int>, val maxOutputSize: Int?) {
    var outputs = mutableListOf<Int>()
    var ip = 0

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
            runInstruction(instructions[ip], instructions[ip + 1])
            if (maxOutputSize != null && outputs.size > maxOutputSize) {
//                outputs.clear()
                return
            }
        }
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

    println("part1 $program, ${computer.getOutputAsString()}")

    var x = 6165808013955L
    var output = ""
    do {
        val c = Computer(x, b, c, instructions, instructions.size)
        c.runProgram()
        x += 1
        output = c.getOutputAsString()
        println("$x - $output - ${c.outputs.size}")
    } while (output != program)
    val part2Result = x - 1
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