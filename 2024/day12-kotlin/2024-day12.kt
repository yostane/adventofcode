///usr/bin/env jbang "$0" "$@" ; exit $?

//KOTLIN 2.1.0
//SOURCES 2024-day12-input.kt

typealias Vec2D = Pair<Int, Int>
typealias SubRegionMap = List<List<Boolean>>
typealias MutableSubRegionMap = MutableList<MutableList<Boolean>>

operator fun Vec2D.minus(rightPosition: Vec2D) =
    this.first - rightPosition.first to this.second - rightPosition.second

operator fun Vec2D.plus(rightPosition: Vec2D) =
    this.first + rightPosition.first to this.second + rightPosition.second

operator fun Vec2D.unaryMinus() =
    -this.first to -this.second

fun Vec2D.isInBox(lineCount: Int, columnCount: Int) =
    this.first in 0..<lineCount && this.second in 0..<columnCount

class Region(val topLeft: Vec2D, val map: SubRegionMap, val regionName: Char) {
    val lineCount = map.size
    val columnCount = map[0].size
    val area: Int
    val perimeter: Int
    val price: Int

    init {
        val ap = getAreaAndPerimeter()
        area = ap.first
        perimeter = ap.second
        price = area * perimeter
    }


    private fun getAreaAndPerimeter(): Pair<Int, Int> {
        var perimeter = 0
        var area = 0
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] == false) {
                    continue
                }
                val neighbours = listOf(i + 1 to j, i - 1 to j, i to j + 1, i to j - 1).count {
                    it.isInBox(lineCount, columnCount) && map[it.first][it.second]
                }
                perimeter += 4 - neighbours
                area += 1
            }
        }
        return area to perimeter
    }

    override fun toString() =
        """Region(topLeft=$topLeft, regionName=$regionName, lineCount=$lineCount, area=$area, perimeter=$perimeter, price=$price), map
${map.joinToString("\n") { it.map { if (it) 'X' else '_' }.joinToString("") }}
""".trimIndent()
}

fun exploreRegion(
    regionName: Char,
    currentPosition: Vec2D,
    map: List<MutableList<Char>>,
    regionMap: MutableSubRegionMap,
    regionTopLeft: Vec2D
) {
    val lineCount = map.size
    val columnCount = map[0].size
    if (!currentPosition.isInBox(lineCount, columnCount)
        || currentPosition.first < regionTopLeft.first
        || regionName != map[currentPosition.first][currentPosition.second]
    ) {
        return
    }
    map[currentPosition.first][currentPosition.second] = '.'
    if (currentPosition.first - regionTopLeft.first > regionMap.lastIndex) {
        // add a new line to the region map
        regionMap.add(MutableList(columnCount) { false })
    }
    val regionMapPosition = currentPosition.first - regionTopLeft.first to currentPosition.second
    regionMap[regionMapPosition.first][regionMapPosition.second] = true
    listOf(
        currentPosition + (1 to 0),
        currentPosition + (0 to 1),
        currentPosition + (-1 to 0),
        currentPosition + (0 to -1)
    ).forEach { exploreRegion(regionName, it, map, regionMap, regionTopLeft) }
}

fun run(input: String) {
    val gardenMap = input.lines().map { it.toMutableList() }
    val regions = mutableListOf<Region>()
    for (i in gardenMap.indices) {
        for (j in gardenMap[i].indices) {
            if (gardenMap[i][j] == '.') {
                continue
            }
            val currentPosition = i to j
            val regionName = gardenMap[i][j]
            val regionMap: MutableSubRegionMap = mutableListOf()
            exploreRegion(regionName, currentPosition, gardenMap, regionMap, currentPosition)
            val region = Region(currentPosition, regionMap, regionName)
//            println("adding region\n$region")
            regions.add(region)
        }
    }
    val part1Result = regions.sumOf { it.price }
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