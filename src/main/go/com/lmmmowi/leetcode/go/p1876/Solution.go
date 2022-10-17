// 1876. 长度为三且各字符不同的子字符串[https://leetcode.cn/problems/substrings-of-size-three-with-distinct-characters/]
package main

import "fmt"

func main() {
	res := countGoodSubstrings("debfvdnhelmyyzt")
	fmt.Println(res)
}

func countGoodSubstrings(s string) int {
	result := 0
	for i := 2; i < len(s); i++ {
		if s[i-2] != s[i-1] && s[i-2] != s[i] && s[i-1] != s[i] {
			result++
		}
	}
	return result
}
