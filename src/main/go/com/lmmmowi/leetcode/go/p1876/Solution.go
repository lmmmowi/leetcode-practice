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
