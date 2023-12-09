import kotlin.math.pow
import kotlin.math.sqrt

class Point2(val x: Double, val y: Double)

class Triangle2(private val a: Point2, private val b: Point2, private val c: Point2) {

    private val ab = sqrt((b.x - a.x).pow(2) + (b.y - a.y).pow(2))
    private val bc = sqrt((b.x - c.x).pow(2) + (b.y - c.y).pow(2))
    private val ac = sqrt((c.x - a.x).pow(2) + (c.y - a.y).pow(2))
    fun circleRadius(): Double {

        println(ab)
        println(bc)
        println(ac)

        val p = (ab + bc + ac) / 2

        return sqrt(((p - ab) * (p - bc) * (p - ac)) / p)
    }

    fun circleCenter(): Point2 {
        val p = ab + bc + ac
        val xCenter = ((bc * a.x) + (ac * b.x) + (ab * c.x)) / p
        val yCenter = ((bc * a.y) + (ac * b.y) + (ab * c.y)) / p

        return Point2(xCenter, yCenter)
    }
}

fun main() {
    val a = Point2(0.0, 0.0)
    val b = Point2(5.0, 1.0)
    val c = Point2(1.0, 5.0)

    val triangle = Triangle2(a, b, c)
    val r = triangle.circleRadius()
    val center = triangle.circleCenter()

    println("Радиус окружности = $r")
    println("Центр окружности = (${center.x}, ${center.y})")
}