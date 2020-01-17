// 115.不同的子序列[https://leetcode-cn.com/problems/distinct-subsequences/]
package main

import "fmt"

func main() {
	num := numDistinct("babgbag", "bag")
	fmt.Print(num)
}

func numDistinct(s string, t string) int {
	ls := len(s)
	lt := len(t)
	dp := make([][]int, ls+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, lt+1)
		dp[i][0] = 1
	}

	for i := 1; i <= ls; i++ {
		k := min(lt, i)
		for j := 1; j <= k; j++ {
			if s[i-1] == t[j-1] {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}

	return dp[ls][lt]
}

func min(x int, y int) int {
	if x < y {
		return x
	} else {
		return y
	}
}
