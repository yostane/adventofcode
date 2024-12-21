import kotlin.math.absoluteValue

typealias Vec2D = Pair<Int, Int>

operator fun Vec2D.minus(rightPosition: Vec2D) =
    this.first - rightPosition.first to this.second - rightPosition.second

operator fun Vec2D.plus(rightPosition: Vec2D) =
    this.first + rightPosition.first to this.second + rightPosition.second

operator fun Vec2D.unaryMinus() =
    -this.first to -this.second

operator fun Vec2D.times(vec2D: Vec2D) =
    this.first * vec2D.first to this.second * vec2D.second

operator fun Vec2D.times(op2: Int) =
    this.first * op2 to this.second * op2

fun Vec2D.isMultipleOfWithSameFactor(vec2D: Vec2D) =
    this.first % vec2D.first == 0 && this.second % vec2D.second == 0 && this.first / vec2D.first == this.second / vec2D.second

fun Vec2D.isInBox(bounds: Vec2D) =
    this.first in 0..<bounds.first && this.second in 0..<bounds.second

operator fun Vec2D.div(vec2D: Vec2D) =
    this.first / vec2D.first to this.second / vec2D.second

operator fun Vec2D.rem(vec2D: Vec2D) =
    this.first % vec2D.first to this.second % vec2D.second

val Vec2D.absoluteValue
    get() = this.first.absoluteValue to this.second.absoluteValue

fun Vec2D.wrapTo(bounds: Vec2D) =
    ((if (this.first < 0) this.first + bounds.first else this.first)
            to if (this.second < 0) this.second + bounds.second else this.second)