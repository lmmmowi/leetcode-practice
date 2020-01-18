// 188.买卖股票的最佳时机 IV[https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/]
package main

import "fmt"

func main() {
	profit := maxProfit(2, []int{3, 2, 6, 5, 0, 3})
	fmt.Print(profit)
}

func maxProfit(k int, prices []int) int {
	days := len(prices)
	if days == 0 {
		return 0
	}

	if k > (days+1)/2 {
		// 相当于没有次数限制，直接用贪心算法
		profit := 0
		for i := 1; i < len(prices); i++ {
			profit += max(prices[i]-prices[i-1], 0)
		}
		return profit
	}

	// a[i]标识当天持股且进行了i次交易的情况下所拥有的最大价值
	a := make([]int, k+1)

	// b[i]标识当天不持股且进行了i次交易的情况下所拥有的最大价值
	b := make([]int, k+1)

	// 第一天
	for i := 0; i <= k; i++ {
		a[i] = -prices[0]
	}

	for i := 1; i < days; i++ {
		for j := 1; j <= k; j++ {
			a[j] = max(a[j], b[j-1]-prices[i])
			b[j] = max(b[j], a[j]+prices[i])
		}
	}

	profit := 0
	for i := 0; i <= k; i++ {
		profit = max(profit, b[i])
	}
	return profit
}

func max(x int, y int) int {
	if x > y {
		return x
	} else {
		return y
	}
}
