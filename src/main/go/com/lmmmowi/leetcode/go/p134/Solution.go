// 134.加油站[https://leetcode-cn.com/problems/gas-station/]
package main

import "fmt"

func main() {
	position := canCompleteCircuit([]int{1, 2, 3, 4, 5}, []int{3, 4, 5, 1, 2})
	fmt.Print(position)
}

func canCompleteCircuit(gas []int, cost []int) int {
	l := len(gas)
	for i := 0; i < l; i++ {
		left := 0
		n := 0
		for n < l {
			pos := (i + n) % l
			left = left + gas[pos] - cost[pos]
			if left < 0 {
				break
			} else {
				n++
			}
		}

		if n == l {
			return i
		}
	}

	return -1
}
