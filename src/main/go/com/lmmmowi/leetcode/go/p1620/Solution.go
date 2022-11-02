// 1620. 网络信号最好的坐标[https://leetcode.cn/problems/coordinate-with-maximum-network-quality/]
package main

import (
	"fmt"
	"math"
)

func main() {
	towers := [][]int{{32, 36, 27}, {17, 22, 43}, {8, 11, 41}, {46, 28, 7}, {22, 4, 35}, {41, 8, 33}, {32, 29, 4}, {44, 32, 16}, {33, 20, 16}, {3, 38, 35}, {17, 47, 23}, {33, 0, 29}, {29, 19, 6}, {4, 50, 46}, {19, 47, 6}, {48, 6, 41}, {20, 26, 35}}
	res := bestCoordinate(towers, 4)
	fmt.Println(res[0], res[1])
}

func bestCoordinate(towers [][]int, radius int) []int {
	xMax := 0
	yMax := 0
	for i := range towers {
		if xMax < towers[i][0] {
			xMax = towers[i][0]
		}

		if yMax < towers[i][1] {
			yMax = towers[i][1]
		}
	}

	max := 0
	res := []int{0, 0}
	for px := 0; px <= xMax; px++ {
		for py := 0; py <= yMax; py++ {
			sum := 0
			for j := range towers {
				x := towers[j][0]
				y := towers[j][1]
				q := towers[j][2]
				temp := calcIntensity(px, py, x, y, q, radius)
				sum += temp
			}

			if sum > max {
				max = sum
				res[0] = px
				res[1] = py
			}
		}
	}

	return res
}

func calcIntensity(x1, y1, x2, y2, q, radius int) int {
	dis := math.Sqrt(float64((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)))
	if dis > float64(radius) {
		return 0
	} else {
		return int(math.Floor(float64(q) / (1 + dis)))
	}
}
