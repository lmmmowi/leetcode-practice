// 739. 每日温度[https://leetcode-cn.com/problems/daily-temperatures/]
package main

import (
	"fmt"
)

func main() {
	temperatures := []int{73, 74, 75, 71, 69, 72, 76, 73}
	result := dailyTemperatures(temperatures)
	fmt.Printf("%v", result)
}

func dailyTemperatures(temperatures []int) []int {
	days := make([]int, len(temperatures))
	stack := make([]int, len(temperatures))
	size := 0

	for i := len(temperatures) - 1; i >= 0; i-- {
		temperature := temperatures[i]

		for ; size > 0; {
			index := stack[size-1]
			if temperatures[index] > temperature {
				days[i] = index - i
				break
			} else {
				size--
			}
		}

		stack[size] = i
		size++
	}

	return days
}
