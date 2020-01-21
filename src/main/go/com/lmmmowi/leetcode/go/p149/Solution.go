// 149.直线上最多的点数[https://leetcode-cn.com/problems/max-points-on-a-line/]
package main

import "fmt"

func main() {
	num := maxPoints([][]int{
		{0, 0}, {94911151, 94911150}, {94911152, 94911151},
	})
	fmt.Println(num)
}

func maxPoints(points [][]int) int {
	points = prepare(points)
	if len(points) == 0 {
		return 0
	} else if len(points) == 1 {
		return points[0][2]
	}

	max := 0
	for i := 0; i < len(points); i++ {
		for j := i + 1; j < len(points); j++ {
			n := points[i][2] + points[j][2]
			rate := calcRate(points[i], points[j])

			for k := j + 1; k < len(points); k++ {
				r := calcRate(points[j], points[k])

				if r == rate {
					n += points[k][2]
				}
			}

			if n > max {
				max = n
			}
		}
	}
	return max
}

func prepare(points [][]int) [][]int {
	fixed := make([][]int, 0)
	for i := 0; i < len(points); i++ {
		found := false
		for j := 0; j < len(fixed); j++ {
			if points[i][0] == fixed[j][0] && points[i][1] == fixed[j][1] {
				fixed[j][2]++
				found = true
				break
			}
		}
		if !found {
			fixed = append(fixed, []int{points[i][0], points[i][1], 1})
		}
	}
	return fixed
}

func calcRate(a, b []int) float64 {
	if a[0] == b[0] {
		return 99999999
	} else if a[1] == b[1] {
		return 0
	} else {
		return float64(b[1]-a[1]) / float64(b[0]-a[0])
	}
}
