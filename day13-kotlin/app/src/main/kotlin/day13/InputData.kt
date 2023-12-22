package day13

val testPatterns = mapOf("""
    #.##..##.
    ..#.##.#.
    ##......#
    ##......#
    ..#.##.#.
    ..##..##.
    #.#.##.#.
""".trimIndent() to 5, """
    #...##..#
    #....#..#
    ..##..###
    #####.##.
    #####.##.
    ..##..###
    #....#..#
""".trimIndent() to 4)

val testInput = testPatterns.keys.joinToString("\n")
