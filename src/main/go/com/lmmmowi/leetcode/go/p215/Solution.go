// 215.数组中的第K个最大元素[https://leetcode-cn.com/problems/kth-largest-element-in-an-array/]
package main

import "fmt"

func main() {
	num := findKthLargest([]int{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)
	fmt.Print(num)
}

func findKthLargest(nums []int, k int) int {
	l := len(nums)
	buildHeap(nums)

	for i := 0; i < k-1; i++ {
		last := l - i - 1
		swap(nums, 0, last)
		adjustHeap(nums, last)
	}

	return nums[0]
}

func buildHeap(nums []int) {
	l := len(nums)
	for i := 1; i < l; i++ {
		m := i

		for m > 0 {
			parent := (m - 1) / 2
			if nums[parent] < nums[m] {
				swap(nums, m, parent)
			}
			m = parent
		}
	}
}

func adjustHeap(nums []int, l int) {
	m := 0

	for true {
		largest := m
		left := m*2 + 1
		right := m*2 + 2

		if left < l && nums[left] > nums[largest] {
			largest = left
		}

		if right < l && nums[right] > nums[largest] {
			largest = right
		}

		if largest != m {
			swap(nums, m, largest)
			m = largest
		} else {
			break
		}
	}
}

func swap(nums []int, i, j int) {
	temp := nums[i]
	nums[i] = nums[j]
	nums[j] = temp
}
