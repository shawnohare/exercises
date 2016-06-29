## Exercise 1

Assuming the two Scala classes

```scala
class Point(val x: Double, val y: Double)
class Rectangle(val ul: Point, val br: Point)
```

are provided, write a function that determins when two
rectangles have non-empty intersection.  Note that we
represent a rectangle as its upper left and bottom right vertices and
assume that its sides are parallel to the coordinate axes.

## Solution

The specification that all rectangles have sides parallel to the
coordinate axes makes this problem fairly simple, because in this
case a rectangle is nothing more than the set product of two 
closed intervals of the reals.  In particular, if R is a rectangle
and I the interval determined by the bottom left and bottom right vertices,
and J the interval determined by the upper vertices, then 
R = I x J.

Given two rectangles R = I x J and S = K x L, R and S are not disjoint
if and only if (a) I and K are not disjoint and (b) J and L are not disjoint.
