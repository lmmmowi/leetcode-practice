// 283.移动零[https://leetcode-cn.com/problems/move-zeroes/]
package main

import "fmt"

func main() {
	nums := []int{0, 1, 0, 3, 12}
	moveZeroes(nums)
	fmt.Println(nums)
}

func moveZeroes(nums []int) {
	ptr := 0
	for _, num := range nums {
		if num != 0 {
			nums[ptr] = num
			ptr++
		}
	}

	for i := ptr; i < len(nums); i++ {
		nums[i] = 0
	}
}
