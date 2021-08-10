// 322. 零钱兑换[https://leetcode-cn.com/problems/coin-change/]
package main

func main() {
	coins := []int{1, 2, 5}
	amount := 11
	res := coinChange(coins, amount)
	println(res)
}

func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)

	for m := 1; m <= amount; m++ {
		dp[m] = -1

		for i := range coins {
			if coins[i] <= m && dp[m-coins[i]] >= 0 {
				dp[m] = min(dp[m], dp[m-coins[i]]+1)
			}
		}
	}

	return dp[amount]
}

func min(x int, y int) int {
	if x >= 0 && x < y {
		return x
	} else {
		return y
	}
}
