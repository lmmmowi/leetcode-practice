// 942. 增减字符串匹配[https://leetcode.cn/problems/di-string-match/]
package main

func diStringMatch(s string) []int {
	n := len(s)
	arr := make([]int, n+1)

	min := 0
	max := n
	for i := 0; i < n; i++ {
		c := s[i]
		if c == 'I' {
			arr[i] = min
			min++
		} else {
			arr[i] = max
			max--
		}
	}

	arr[n] = min
	return arr
}
