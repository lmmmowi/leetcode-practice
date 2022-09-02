// 410. 分割数组的最大值[https://leetcode.cn/problems/split-array-largest-sum/]
package main

func splitArray(nums []int, m int) int {
	n := len(nums)
	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, m+1)
	}

	for i := 1; i <= n; i++ {
		g := min(i, m)
		for j := 1; j <= g; j++ {
			lastGroupSum := 0
			for k := i; k >= j; k-- {
				lastGroupSum += nums[k-1]
				if k > 1 && j <= 1 {
					continue
				}

				maxSum := max(dp[k-1][j-1], lastGroupSum)
				if dp[i][j] == 0 {
					dp[i][j] = maxSum
				} else {
					dp[i][j] = min(dp[i][j], maxSum)
				}

				if maxSum == lastGroupSum {
					break
				}
			}
		}
	}

	return dp[n][m]
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
