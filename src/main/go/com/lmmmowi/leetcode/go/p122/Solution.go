// 122.买卖股票的最佳时机 II[https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/]
package main

func main() {
	print(maxProfit([]int{1, 2, 3, 4, 5}))
}

func maxProfit(prices []int) int {
	days := len(prices)
	if days == 0 {
		return 0
	}

	// a[i]标识第i持股的情况下所拥有的最大价值
	a := make([]int, days)
	a[0] = -prices[0]

	// b[i]标识第i不持股的情况下所拥有的最大价值
	b := make([]int, days)
	b[0] = 0

	for i := 1; i < days; i++ {
		a[i] = max(a[i-1], b[i-1]-prices[i])
		b[i] = max(b[i-1], a[i-1]+prices[i])
	}

	return max(a[days-1], b[days-1])
}

func max(x int, y int) int {
	if x > y {
		return x
	} else {
		return y
	}
}
