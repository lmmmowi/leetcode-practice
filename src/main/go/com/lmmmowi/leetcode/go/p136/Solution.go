// 136.只出现一次的数字[https://leetcode-cn.com/problems/single-number/]
package main

import "fmt"

func main() {
	x := singleNumber([]int{2, 2, 1})
	fmt.Print(x)
}

func singleNumber(nums []int) int {
	result := 0
	for i := 0; i < len(nums); i++ {
		result ^= nums[i]
	}
	return result
}
