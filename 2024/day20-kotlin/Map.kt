typealias Map = List<MutableList<Char>>

operator fun Map.get(vec2D: Vec2D) = this[vec2D.first][vec2D.second]
operator fun Map.set(vec2D: Vec2D, char: Char) {
    this[vec2D.first][vec2D.second] = char
}

fun Map.isInBorder(vec2D: Vec2D) =
    vec2D.first == 0 || vec2D.first == lastIndex || vec2D.second == 0 || vec2D.second == this[0].lastIndex

fun Map.asString() = joinToString("\n") { it.joinToString("") }