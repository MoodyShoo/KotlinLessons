import kotlin.math.pow
import kotlin.math.sqrt

class Point(val x: Double, val y: Double)

class Triangle(private val a: Point, private val b: Point, private val c: Point) {

    fun circleRadius(): Double {
        val ab = sqrt((b.x - a.x).pow(2) + (b.y - a.y).pow(2))
        val bc = sqrt((b.x - c.x).pow(2) + (b.y - c.y).pow(2))
        val ac = sqrt((c.x - a.x).pow(2) + (c.y - a.y).pow(2))

        val p = (ab + bc + ac) / 2

        return (ab * bc * ac) / (4 * sqrt(p * (p - ab) * (p - bc) * (p - ac)))
    }

    fun circleCenter(): Point {
        val s = 2 * (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))
        val xCenter =
            ((a.x.pow(2) + a.y.pow(2)) * (b.y - c.y) + (b.x.pow(2) + b.y.pow(2)) * (c.y - a.y) + (c.x.pow(2) + c.y.pow(2)) * (a.y - b.y)) / s
        val yCenter =
            ((a.x.pow(2) + a.y.pow(2)) * (c.x - b.x) + (b.x.pow(2) + b.y.pow(2)) * (a.x - c.x) + (c.x.pow(2) + c.y.pow(2)) * (b.x - a.x)) / s

        return Point(xCenter, yCenter)
    }
}

fun main() {
    val a = Point(0.0, 0.0)
    val b = Point(5.0, 1.0)
    val c = Point(1.0, 5.0)

    val triangle = Triangle(a, b, c)
    val r = triangle.circleRadius()
    val center = triangle.circleCenter()

    println("Радиус окружности = $r")
    println("Центр окружности = (${center.x}, ${center.y})")
}