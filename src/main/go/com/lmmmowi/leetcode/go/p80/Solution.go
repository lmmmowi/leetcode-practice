// 80.删除排序数组中的重复项 II[https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/]
package main

import "fmt"

func main() {
	l := removeDuplicates([]int{0, 0, 1, 1, 1, 1, 2, 3, 3})
	fmt.Print(l)
}

func removeDuplicates(nums []int) int {
	var meetVal, meetCount int
	index := 0

	for i := range nums {
		if i == 0 || meetVal != nums[i] {
			meetVal = nums[i]
			meetCount = 1
		} else if meetCount <= 1 {
			meetCount++
		} else {
			continue
		}

		nums[index] = nums[i]
		index++
	}

	return index
}
