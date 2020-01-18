// 202.快乐数[https://leetcode-cn.com/problems/happy-number/]
package main

import "fmt"

func main() {
	yes := isHappy(20)
	fmt.Print(yes)
}

func isHappy(n int) bool {
	exist := []int{n}
	for n != 1 {
		sum := 0
		k := n
		for ; k > 0; k /= 10 {
			i := k % 10
			sum += i * i
		}

		for i := range exist {
			if exist[i] == sum {
				return false
			}
		}

		n = sum
		exist = append(exist, n)
	}
	return true
}
