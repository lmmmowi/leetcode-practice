// 89.格雷编码[https://leetcode-cn.com/problems/gray-code/]
package main

import (
	"fmt"
	"math"
)

func main() {
	result := grayCode(3)
	fmt.Println(result)
}

func grayCode(n int) []int {
	bits := make([]bool, n)
	m := int(math.Pow(2, float64(n)))
	result := make([]int, m)
	flags := make([]bool, m)
	flags[0] = true
	find(bits, result, flags, m, 1, -1)
	return result
}

func find(bits []bool, result []int, flags []bool, m int, index int, lastChanged int) bool {
	if index == m {
		return true
	}

	for i := 0; i < len(bits); i++ {
		if i == lastChanged {
			continue
		}

		temp := bits[i]
		bits[i] = !temp
		val := getVal(bits)
		if val <= m && !flags[val] {
			flags[val] = true
			result[index] = val
			found := find(bits, result, flags, m, index+1, i)
			if found {
				return true
			}
			result[index] = 0
			flags[val] = false
		}
		bits[i] = temp
	}

	return false
}

func getVal(bits []bool) int {
	val := 0
	for i := 0; i < len(bits); i++ {
		if bits[i] {
			val += 1 << uint(i)
		}
	}
	return val
}
