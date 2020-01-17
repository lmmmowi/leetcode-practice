// 120.三角形最小路径和[https://leetcode-cn.com/problems/triangle/]
package main

import "fmt"

func main() {
	total := minimumTotal([][]int{
		{2},
		{3, 4},
		{6, 5, 7},
		{4, 1, 8, 3},
	})
	fmt.Print(total)
}

func minimumTotal(triangle [][]int) int {
	rowCount := len(triangle)
	if rowCount == 0 {
		return 0
	}

	dp := make([]int, rowCount)
	dp[0] = triangle[0][0]
	for i := 1; i < rowCount; i++ {
		colCount := i + 1
		for j := colCount - 1; j >= 0; j-- {
			if j == 0 {
				dp[j] = dp[j] + triangle[i][j]
			} else if j == i {
				dp[j] = dp[j-1] + triangle[i][j]
			} else {
				dp[j] = min(dp[j], dp[j-1]) + triangle[i][j]
			}
		}
	}

	res := dp[0]
	for i := range dp {
		res = min(res, dp[i])
	}
	return res
}

func min(x int, y int) int {
	if x < y {
		return x
	} else {
		return y
	}
}
