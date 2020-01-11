// 76.最小覆盖子串[https://leetcode-cn.com/problems/minimum-window-substring/]
package main

import "fmt"

func main() {
	//s := minWindow("ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country", "ask_country")
	//s := minWindow("ADOBECODEBANC", "ABC")
	s := minWindow("cabwefgewcwaefgcf", "cae")
	fmt.Println("result==>", s)
}

func minWindow(s string, t string) string {
	if len(s) < len(t) {
		return ""
	}

	ss := make([]int, 128)
	tt := make([]int, 128)
	initArray(s, ss, 0, len(t))
	initArray(t, tt, 0, len(t))

	var result = ""
	left := 0
	right := len(t) - 1
	checkIndex := uint8(0)

	for true {
		ok := contains(ss, tt, checkIndex)
		if ok {
			length := right - left + 1
			if result == "" || length < len(result) {
				result = s[left : right+1]
			}

			// 移动左边窗口
			checkIndex = s[left]
			ss[s[left]] -= 1
			left++
		} else {
			if right+1 >= len(s) {
				break
			}

			// 移动右边窗口
			right++
			ss[s[right]] += 1
		}
	}

	return result
}

func initArray(s string, arr []int, begin int, end int) {
	for i := 0; i < len(arr); i++ {
		arr[i] = 0
	}
	for i := begin; i < end; i++ {
		arr[s[i]] += 1
	}
}

func contains(ss []int, tt []int, checkIndex uint8) bool {
	if checkIndex > 0 {
		return ss[checkIndex] >= tt[checkIndex]
	} else {
		for i := 0; i < len(ss); i++ {
			if tt[i] > 0 && ss[i] < tt[i] {
				return false
			}
		}
		return true
	}
}
