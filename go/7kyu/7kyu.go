package main

import "math"

// IsTriangle implement a method that accepts 3 integer values a, b, c.
// The method should return true if a triangle can be built with the sides of given length and false in any other case.
// (In this case, all triangles must have surface greater than 0 to be accepted).
func IsTriangle(a, b, c int) bool {
	return (a+b > c) && (b+c > a) && (c+a > b)
}

// MakeNegative  In this simple assignment you are given a number and have to make it negative. But maybe the number is already negative?
// The number can be negative already, in which case no change is required.
// Zero (0) is not checked for any specific sign. Negative zeros make no mathematical sense.
func MakeNegative(x int) int {
	return -int(math.Abs(float64(x)))
}

func MakeNegativePure(x int) int {
	if x >= 0 {
		return -x
	}
	return x
}

func main() {}
