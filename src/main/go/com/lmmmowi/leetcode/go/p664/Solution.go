// 664. 奇怪的打印机[https://leetcode-cn.com/problems/strange-printer/]
package main

func strangePrinter(s string) int {
	//s = shorten(s)
	println(s)

	n := len(s)
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, n)
		dp[i][i] = 1
	}

	for l := 2; l <= n; l++ {
		for b := 0; b < n-l+1; b++ {
			e := b + l - 1
			dp[b][e] = n

			if s[b] == s[e] {
				// 错误思路：temp = min(temp, dp[b+1][e-1]+1)
				// 典型用例：abacada
				dp[b][e] = min(dp[b][e], dp[b][e-1])
			} else {
				for m := b; m < e; m++ {
					dp[b][e] = min(dp[b][e], dp[b][m]+dp[m+1][e])
				}
			}
		}
	}

	return dp[0][n-1]
}

func min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
