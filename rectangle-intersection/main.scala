// provided classes
class Point(val x: Double, val y: Double)
class Rectangle(val ul: Point, val br: Point)
// new classes
class Interval(val min: Double, val max: Double) {
    def contains(x: Double): Boolean = {
        min <= x && x <= max
    }
    def intersects(I: Interval): Boolean = {
        contains(I.min) || contains(I.max) || I.contains(min) || I.contains(max)
    }
}
// rectangle as the Cartesian product of two intervals
class RectangleAsProduct(val I1: Interval, val I2: Interval) {
    def intersects(R: RectangleAsProduct): Boolean = {
        I1.intersects(R.I1) && I2.intersects(R.I2)
    }
}

def intervals_intersect(I: Interval, J: Interval): Boolean = {
    I.intersects(J)
}

def convert_Rectangle_to_RectangleAsProduct(R: Rectangle) = {
    val I = new Interval(R.ul.x, R.br.x)
    val J = new Interval(R.br.y, R.ul.y) 
    new RectangleAsProduct(I, J)
}

def rectangles_intersect(R1: Rectangle, R2: Rectangle): Boolean = {
    // convert provided rectangles into set products
    val R = convert_Rectangle_to_RectangleAsProduct(R1)
    val S = convert_Rectangle_to_RectangleAsProduct(R2)
    R.intersects(S)
}