// 746. 使用最小花费爬楼梯[https://leetcode-cn.com/problems/min-cost-climbing-stairs/]
package main

func main() {
	cost := []int{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
	res := minCostClimbingStairs(cost)
	println(res)
}

func minCostClimbingStairs(cost []int) int {
	n := len(cost)
	dp := make([]int, n+1)

	for i := 2; i <= n; i++ {
		dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
	}

	return dp[n]
}

func min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
