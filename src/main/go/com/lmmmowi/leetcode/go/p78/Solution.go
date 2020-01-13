// 78.子集[https://leetcode-cn.com/problems/subsets/]
package main

import "fmt"

func main() {
	result := subsets([]int{1, 2, 3})
	for i := range result {
		fmt.Print("LINE==>[")
		for j := range result[i] {
			fmt.Print(result[i][j], ",")
		}
		fmt.Println("]")
	}
}

func subsets(nums []int) [][]int {
	result := [][]int{{}}

	for n := 1; n <= len(nums); n++ {
		result = find(n, 0, 0, nums, make([]int, len(nums)), result)
	}

	return result
}

func find(n int, m int, k int, nums []int, arr []int, result [][]int) [][]int {
	if n == m {
		item := make([]int, n)
		copy(item, arr)
		return append(result, item)
	}

	for i := k; i < len(nums)-(n-m)+1; i++ {
		arr[m] = nums[i]
		result = find(n, m+1, i+1, nums, arr, result)
	}

	return result
}
