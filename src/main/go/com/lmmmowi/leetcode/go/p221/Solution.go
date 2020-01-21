// 221.最大正方形[https://leetcode-cn.com/problems/maximal-square/]
package main

import "fmt"

func main() {
	size := maximalSquare([][]byte{
		{1, 0, 1, 0, 0},
		{1, 0, 1, 1, 1},
		{1, 1, 1, 1, 1},
		{1, 0, 0, 1, 0},
	})
	fmt.Println(size)
}

func maximalSquare(matrix [][]byte) int {
	if len(matrix) == 0 {
		return 0
	}

	col := len(matrix[0])
	dp := make([]int, col)
	rdp := make([]int, col)
	cdp := make([]int, col)

	maxLen := 0
	for i := 0; i < len(matrix); i++ {
		prevDp := 0
		for j := 0; j < col; j++ {
			if matrix[i][j] == '0' {
				dp[j] = 0
				cdp[j] = 0
				rdp[j] = 0
			} else {
				if j == 0 {
					cdp[j] = 1
				} else {
					cdp[j] = cdp[j-1] + 1
				}

				if i == 0 {
					rdp[j] = 1
				} else {
					rdp[j] = rdp[j] + 1
				}

				temp := dp[j]
				dp[j] = min(rdp[j], cdp[j])
				if i > 0 && j > 0 {
					dp[j] = min(dp[j], prevDp+1)
				}
				prevDp = temp

				if dp[j] > maxLen {
					maxLen = dp[j]
				}
			}
		}
	}

	return maxLen * maxLen
}

func min(x, y int) int {
	if x < y {
		return x
	} else {
		return y
	}
}
