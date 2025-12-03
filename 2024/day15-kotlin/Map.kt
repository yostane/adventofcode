typealias Map = List<MutableList<Char>>

operator fun Map.get(vec2D: Vec2D) = this[vec2D.first][vec2D.second]
operator fun Map.set(vec2D: Vec2D, char: Char) {
    this[vec2D.first][vec2D.second] = char
}

fun Map.asString() = joinToString("\n") { it.joinToString("") }