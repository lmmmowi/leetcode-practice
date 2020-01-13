// 90.子集 II[https://leetcode-cn.com/problems/subsets-ii/]
package main

import "fmt"

func main() {
	result := subsetsWithDup([]int{4, 4, 4, 1, 4})
	for i := range result {
		fmt.Print("LINE==>[")
		for j := range result[i] {
			fmt.Print(result[i][j], ",")
		}
		fmt.Println("]")
	}
}

func subsetsWithDup(nums []int) [][]int {
	result := [][]int{{}}

	sort(nums)
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

	first := len(nums) - (n - m) + 1
	if k <= first {
		w := nums[k] + 1
		for i := k; i < first; i++ {
			if nums[i] == w {
				continue
			}
			w = nums[i]

			arr[m] = nums[i]
			result = find(n, m+1, i+1, nums, arr, result)
		}
	}

	return result
}

func sort(arr []int) {
	for i := 0; i < len(arr); i++ {
		for j := i + 1; j < len(arr); j++ {
			if arr[i] > arr[j] {
				temp := arr[i]
				arr[i] = arr[j]
				arr[j] = temp
			}
		}
	}
}
