// 77.组合[https://leetcode-cn.com/problems/combinations/]
package main

import "fmt"

func main() {
	result := combine(4, 2)

	for i := range result {
		fmt.Println(result[i])
	}
}

func combine(n int, k int) [][]int {
	total := 1
	for i := 0; i < k; i++ {
		total *= n - i
	}
	for i := 0; i < k; i++ {
		total /= i + 1
	}

	result := make([][]int, total)
	count := 0
	find(n, k, 0, make([]int, k), result, &count)
	return result
}

func find(n int, k int, index int, arr []int, result [][]int, count *int) {
	if k == index {
		item := make([]int, k)
		copy(item, arr)
		result[*count] = item
		*count += 1
		return
	}

	from := 0
	if index > 0 {
		from = arr[index-1]
	}

	for i := from; i < n; i++ {
		arr[index] = i + 1
		find(n, k, index+1, arr, result, count)
	}
}
