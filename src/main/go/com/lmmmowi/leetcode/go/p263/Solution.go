// 263. 丑数[https://leetcode-cn.com/problems/ugly-number/]
package main

func isUgly(n int) bool {
	for n > 0  && n % 2 == 0 {
		n = n / 2
	}

	for n > 0  && n % 3 == 0 {
		n = n / 3
	}

	for n > 0  && n % 5 == 0 {
		n = n / 5
	}

	return n == 1
}
