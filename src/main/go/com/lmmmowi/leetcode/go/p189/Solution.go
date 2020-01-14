// 189.旋转数组[https://leetcode-cn.com/problems/rotate-array/]
package main

import "fmt"

func main() {
	arr := []int{1, 2, 3, 4, 5, 6, 7}
	rotate(arr, 3)
	for i := range arr {
		fmt.Print(arr[i], ",")
	}
}

func rotate(nums []int, k int) {
	l := len(nums)
	k %= l

	pos := 0
	value := nums[pos]
	walk := 0

	for i := 0; i < l; i++ {
		if walk > 0 && walk%l == 0 {
			pos++
			value = nums[pos]
			walk = 0
		}

		nextPos := (pos + k) % l
		temp := nums[nextPos]
		nums[nextPos] = value

		pos = nextPos
		value = temp
		walk += k
	}
}
