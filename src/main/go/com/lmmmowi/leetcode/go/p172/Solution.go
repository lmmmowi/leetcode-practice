// 172.阶乘后的零[https://leetcode-cn.com/problems/factorial-trailing-zeroes/]
package main

import "fmt"

func main() {
	zeros := trailingZeroes(27)
	fmt.Print(zeros)
}

func trailingZeroes(n int) int {
	if n < 5 {
		return 0
	}

	k := 1
	m := 0

	for k < n {
		k *= 5
		m = m*5 + 1
	}
	if k > n {
		k /= 5
		m = (m - 1) / 5
	}

	return m + trailingZeroes(n-k)
}
