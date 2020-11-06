// 268.丢失的数字[https://leetcode-cn.com/problems/missing-number/]
package main

import (
	"fmt"
)

func main() {
	number := missingNumber([]int{1, 2, 0})
	fmt.Println(number)
}

func missingNumber(nums []int) int {
	n := len(nums)

	for i := 0; i < n; i++ {
		nextIndex := nums[i]

		if nextIndex < 0 {
			nextIndex += n + 1
		}

		if nextIndex < n && nums[nextIndex] >= 0 {
			nums[nextIndex] -= n + 1
		}
	}

	for i := 0; i < n; i++ {
		if nums[i] >= 0 {
			return i
		}
	}

	return n
}
