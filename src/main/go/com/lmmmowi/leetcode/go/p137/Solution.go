// 137.只出现一次的数字 II[https://leetcode-cn.com/problems/single-number-ii/]
package main

import "fmt"

func main() {
	x := singleNumber([]int{4,3,3,3})
	fmt.Print(x)
}

func singleNumber(nums []int) int {
	l, h, t := 0, 0, 0
	for i := 0; i < len(nums); i++ {
		h |= l & nums[i]
		l ^= nums[i]
		t = h & l
		l &= ^t
		h &= ^t

	}
	return l
}
