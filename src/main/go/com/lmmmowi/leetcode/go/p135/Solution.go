// 135.分发糖果[https://leetcode-cn.com/problems/candy/]
package main

import "fmt"

func main() {
	//num := candy([]int{16, 10, 8, 7, 3, 2})
	num := candy([]int{1, 2, 3, 1, 0})
	fmt.Println(num)
}

func candy(ratings []int) int {
	candies := make([]int, len(ratings))
	candies[0] = 1
	for i := 1; i < len(ratings); i++ {
		if ratings[i] > ratings[i-1] {
			candies[i] = candies[i-1] + 1
		} else if ratings[i] < ratings[i-1] {
			candies[i] = min(candies[i-1]-1, 1)
		} else {
			candies[i] = 1
		}
	}

	toAdd := 0
	for i := len(ratings) - 1; i >= 0; i-- {
		if toAdd > 0 {
			candies[i] += toAdd
		}

		if candies[i] <= 0 {
			toAdd = 1 - candies[i]
			candies[i] += toAdd
		}

		if i > 0 {
			if ratings[i-1] > ratings[i] && candies[i-1] <= candies[i] {
				toAdd = candies[i] + 1 - candies[i-1]
			} else {
				toAdd = 0
			}
		}
	}

	for i := 1; i < len(ratings); i++ {
		if ratings[i] > ratings[i-1] && candies[i] <= candies[i-1] {
			candies[i] = candies[i-1] + 1
		}
	}

	sum := 0
	for i := range candies {
		sum += candies[i]
	}
	return sum
}

func min(x, y int) int {
	if x < y {
		return x
	} else {
		return y
	}
}
