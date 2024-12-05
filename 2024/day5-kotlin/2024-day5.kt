///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES input.kt

fun isPrintingCorrect(
    pages: List<Int>, orderingRulesGroups: Map<Int, List<Int>>
) = pages.mapIndexed { index, page -> index to page }.all { pair ->
    val index = pair.first
    val page = pair.second
    if (index == pages.size - 1) {
        return@all true
    }
    val nextPages = pages.drop(index + 1)
    val isAllNextPagesCorrect = orderingRulesGroups[page]?.let { orderingRules ->
        nextPages.all { orderingRules.contains(it) }
    } != false
    val isReverseOrderingRuleRespected = nextPages.mapNotNull { orderingRulesGroups[it] }.none { it.contains(page) }
    return@all isAllNextPagesCorrect && isReverseOrderingRuleRespected
}

fun run(input: String) {
    val inputParts = input.split("\n\n")
    require(inputParts.size == 2)
    val printingInputs = inputParts[1].lines().map { it.split(",").map(String::toInt) }
    val orderingRulesGroups =
        inputParts[0].lines().map { it.substringBefore('|').toInt() to it.substringAfter('|').toInt() }
            .groupBy({ it.first }) { it.second }
    val part1Result =
        printingInputs.filter { isPrintingCorrect(it, orderingRulesGroups) }.sumOf { line -> line[line.size / 2] }
    println("part1 $part1Result")

    val part2Result = printingInputs.filter { !isPrintingCorrect(it, orderingRulesGroups) }
        .sumOf { getMiddlePageAfterFix(it.toMutableList(), orderingRulesGroups) }
    println("part2 $part2Result")
}

fun getMiddlePageAfterFix(pages: MutableList<Int>, orderingRulesGroups: Map<Int, List<Int>>): Int {
    pages.mapIndexedNotNull { index, page ->
        if (index == pages.size - 1) {
            return@mapIndexedNotNull null
        }
        pages.drop(index + 1)
            .mapIndexedNotNull { i, np ->
                if (orderingRulesGroups.getOrDefault(np, emptyList()).contains(page)) i else null
            }
            .map { index to it + index + 1 }
            .firstOrNull()
    }.forEach {
        val tmp = pages[it.first]
        pages[it.first] = pages[it.second]
        pages[it.second] = tmp
    }
    if (!isPrintingCorrect(pages, orderingRulesGroups)) {
        return getMiddlePageAfterFix(pages, orderingRulesGroups)
    }
    return pages[pages.size / 2]
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