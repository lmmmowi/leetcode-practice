// 125.验证回文串[https://leetcode-cn.com/problems/valid-palindrome/]
package main

import "fmt"

func main() {
	result := isPalindrome("0P")
	fmt.Println(result)
}

func isPalindrome(s string) bool {
	begin := 0
	end := len(s) - 1

	for begin < end {
		bc := getCharacter(s[begin])
		for ; bc == 0 && begin < end; bc = getCharacter(s[begin]) {
			begin++
		}

		ec := getCharacter(s[end])
		for ; ec == 0 && begin < end; ec = getCharacter(s[end]) {
			end--
		}

		if bc == ec {
			begin++
			end--
		} else {
			return false
		}
	}

	return true
}

func getCharacter(c uint8) uint8 {
	if c >= 'a' && c <= 'z' {
		return c
	} else if c >= 'A' && c <= 'Z' {
		return c - 'A' + 'a'
	} else if c >= '0' && c <= '9' {
		return c
	} else {
		return 0
	}
}
