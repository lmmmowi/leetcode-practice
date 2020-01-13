// 84.柱状图中最大的矩形[https://leetcode-cn.com/problems/largest-rectangle-in-histogram/]
package main

import (
	"container/list"
	"fmt"
)

func main() {
	res := largestRectangleArea([]int{2, 1, 5, 6, 2, 3})
	fmt.Println(res)
}

func largestRectangleArea(heights []int) int {
	result := 0
	stack := list.New()
	stack.PushBack(-1)

	// 依次进栈
	for i := 0; i < len(heights); i++ {
		element := stack.Back()
		tail := element.Value.(int)

		for tail >= 0 && heights[i] < heights[tail] {
			right := i - 1
			left := element.Prev().Value.(int)
			width := right - left
			height := heights[tail]
			result = max(width*height, result)

			// 出栈
			stack.Remove(element)
			element = stack.Back()
			tail = element.Value.(int)
		}

		stack.PushBack(i)
	}

	// 依次出栈
	right := stack.Back().Value.(int)
	for stack.Len() > 1 {
		element := stack.Back()
		left := element.Prev().Value.(int)
		width := right - left
		height := heights[element.Value.(int)]
		result = max(width*height, result)

		// 出栈
		stack.Remove(element)
	}

	return result
}

func max(x int, y int) int {
	if x > y {
		return x
	} else {
		return y
	}
}
