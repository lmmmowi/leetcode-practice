// 338. 比特位计数[https://leetcode-cn.com/problems/counting-bits/]
package main

func countBits(n int) []int {
	result := make([]int, n+1)
	for i := 1; i <= n; i++ {
		result[i] = result[i>>1] + (i & 1)
	}
	return result
}
