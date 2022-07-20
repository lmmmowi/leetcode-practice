// 880. 索引处的解码字符串[https://leetcode.cn/problems/decoded-string-at-index/]
package main

func main() {
	s := decodeAtIndex("leet2code3", 10)
	println(s)
}

func decodeAtIndex(s string, k int) string {
	return decodeAtIndexRecursive(s, k, 0, 0)
}

func decodeAtIndexRecursive(s string, k int, i int, prevLen int) string {
	c := s[i]
	isNumber := c >= '0' && c <= '9'

	var curLen int
	if isNumber {
		curLen = prevLen * int(c-'0')
	} else {
		curLen = prevLen + 1
	}

	if curLen < k {
		return decodeAtIndexRecursive(s, k, i+1, curLen)
	}

	if isNumber {
		mod := k % prevLen
		newK := mod
		if mod == 0 {
			newK = prevLen
		}
		return decodeAtIndexRecursive(s, newK, 0, 0)
	} else {
		return string(c)
	}
}
