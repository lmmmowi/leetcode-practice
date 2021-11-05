// 768. 最多能完成排序的块 II[https://leetcode-cn.com/problems/max-chunks-to-make-sorted-ii/]
package main

import "fmt"

func main() {
	arr := []int{1, 2, 0, 3}
	count := maxChunksToSorted(arr)
	fmt.Printf("%d", count)
}

func maxChunksToSorted(arr []int) int {
	stack := make([]int, len(arr))
	size := 0
	for i := range arr {
		if size == 0 || arr[i] >= stack[size-1] {
			stack[size] = arr[i]
			size++
		} else {
			size--
			top := stack[size]

			for ; size > 0; {
				if arr[i] < stack[size-1] {
					size--
				} else {
					break
				}
			}

			stack[size] = top
			size++
		}
	}
	return size
}
