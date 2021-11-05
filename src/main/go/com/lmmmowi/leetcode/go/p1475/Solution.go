// 1475. 商品折扣后的最终价格[https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/]
package main

import (
	"fmt"
)

func main() {
	arrAge := []int{8, 4, 6, 2, 3}
	prices := finalPrices(arrAge)
	fmt.Printf("%v", prices)
}

func finalPrices(prices []int) []int {
	stack := make([]int, len(prices))
	size := 0

	for i := len(prices) - 1; i >= 0; i-- {
		price := prices[i]

		for ; size > 0; size-- {
			if stack[size-1] <= price {
				prices[i] -= stack[size-1]
				break
			}
		}

		stack[size] = price
		size++
	}

	return prices
}
