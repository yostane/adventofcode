import javax.swing.text.Position

///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES input.kt

val operators = listOf('+', '*')

typealias LongBinaryExtOp = Long.(Long) -> Long

data class Tree(val leftChild: Tree?, val rightChild: Tree?, val operand: LongBinaryExtOp)

fun isOperationPossibleRecursive(currentValue: Long, expectedResult: Long, operands: List<Long>, currentPosition: Int, shouldConcatenate: Boolean): Boolean {
    if(currentValue == expectedResult && currentPosition == operands.size){
        return true
    }
    if (currentValue > expectedResult || currentPosition > operands.lastIndex){
        return false
    }
    val result = isOperationPossibleRecursive(currentValue + operands[currentPosition], expectedResult, operands, currentPosition + 1, shouldConcatenate)
            || isOperationPossibleRecursive(currentValue * operands[currentPosition], expectedResult, operands, currentPosition + 1, shouldConcatenate)
            || (shouldConcatenate && isOperationPossibleRecursive("$currentValue${operands[currentPosition]}".toLong(), expectedResult, operands, currentPosition + 1, true))
    return result
}

fun run(input: String) {
    val equations = input.lines()
    val operations = equations.map {
        val result = it.substringBefore(':').toLong()
        val operands = it.substringAfter(": ").split(' ').map(String::toLong)
        result to operands
    }
    val part1Result = operations.filter {(result, operands) ->
        isOperationPossibleRecursive(operands[0], result, operands, 1,false)
    }.sumOf { (result, operand) -> result  }
    println("part1 $part1Result")

    val part2Result = operations.filter {(result, operands) ->
        isOperationPossibleRecursive(operands[0], result, operands, 1, true)
    }.sumOf { (result, operand) -> result  }
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