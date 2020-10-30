// 290.单词规律[https://leetcode-cn.com/problems/word-pattern/]
package main

import (
	"strings"
)

func main() {
	wordPattern("abba", "dog cat cat dog")
}

func wordPattern(pattern string, s string) bool {
	parts := strings.Split(s, " ")
	if len(pattern) != len(parts) {
		return false
	}

	arr := [26]string{}
	for i := range pattern {
		index := pattern[i] - 'a'
		if arr[index] == "" || arr[index] == parts[i] {
			arr[index] = parts[i]
		} else {
			return false
		}
	}

	for i := 0; i < len(arr); i++ {
		for j := i + 1; j < len(arr); j++ {
			if arr[i] != "" && arr[i] == arr[j] {
				return false
			}
		}
	}

	return true
}
