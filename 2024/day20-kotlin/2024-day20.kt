///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day20-input.kt

const val START = 'S'
const val END = 'E'
const val TRACK = '.'
const val WALL = '#'
val moves = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

class Race(val map: Map) {
    val startPosition: Vec2D
    val endPosition: Vec2D
    val shortestTrack = mutableListOf<Vec2D>()

    init {
        startPosition = find(map, START)
        endPosition = find(map, END)
    }

    private fun find(map: Map, char: Char): Vec2D {
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] == char) return i to j
            }
        }
        throw Error("$char not found")
    }

    private fun findShortestRoute(map: Map, start: Vec2D): List<Vec2D> {
        val routes = moves.map { mutableListOf(start, start + it) }.toMutableList()
        while (routes.isNotEmpty()) {
            for (r in routes.indices.reversed()) {
                val position = routes[r].last()
                val item = map[position]
                when (item) {
                    WALL, START -> routes.removeAt(r)
                    END -> return routes[r].toList()
                }
                routes.removeIf {
                    it.size > routes[r].size && it.contains(position)
                }
            }
            routes.flatMap {
                val lastPoint = it.last()
                moves.mapNotNull { move ->
                    val p = lastPoint + move
                    if (map[p] != WALL && !map.isInBorder(p)) {
                        val output = mutableListOf<Vec2D>()
                        output.addAll(it)
                        output.add(p)
                    } else null
                }
            }
            routes.sortBy { it.size }
        }
        throw Error("Shorter route not found")
    }
}

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