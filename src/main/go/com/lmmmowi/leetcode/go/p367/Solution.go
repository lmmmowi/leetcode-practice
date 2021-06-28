// 367. 有效的完全平方数[https://leetcode-cn.com/problems/valid-perfect-square/]
package main

func isPerfectSquare(num int) bool {
	i := 1
	for true {
		res := i * i
		if res == num {
			return true
		} else if res > num {
			break
		} else {
			i++
		}
	}
	return false
}
