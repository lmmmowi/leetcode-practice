// 258.各位相加[https://leetcode-cn.com/problems/add-digits/]
package main

import (
	"fmt"
)

func main() {
	result := addDigits(38)
	fmt.Println(result)
}

func addDigits(num int) int {
	for ; num >= 10; {
		temp := 0
		for ; num > 0; {
			temp += num % 10
			num /= 10
		}
		num = temp
	}
	return num
}
