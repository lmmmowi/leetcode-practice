// 392. 判断子序列[https://leetcode-cn.com/problems/is-subsequence/]
package main

func isSubsequence(s string, t string) bool {
	m := len(s)
	n := len(t)
	dp := make([][]bool, m+1)
	for i := range dp {
		dp[i] = make([]bool, n+1)
	}

	for i := 0; i <= m; i++ {
		for j := i; j <= n; j++ {
			dp[i][j] = i == 0 || dp[i][j-1] || (dp[i-1][j-1] && s[i-1] == t[j-1])
		}
	}

	return dp[m][n]
}
