// 316. 去除重复字母[https://leetcode.cn/problems/remove-duplicate-letters/]
package main

func main() {
	removeDuplicateLetters("cbacdcbc")
}

func removeDuplicateLetters(s string) string {
	counters := make([]int, 26)
	for i := range s {
		c := s[i] - 'a'
		counters[c]++
	}

	stack := make([]byte, 26)
	stackSize := 0
	inStack := make([]bool, 26)
	for i := range s {
		c := s[i] - 'a'
		counters[c]--
		if inStack[c] {
			continue
		}

		for stackSize > 0 {
			top := stack[stackSize-1]
			if top > c && counters[top] > 0 {
				stackSize--
				inStack[top] = false
			} else {
				break
			}
		}

		stack[stackSize] = c
		stackSize++
		inStack[c] = true
	}

	res := stack[0:stackSize]
	for i := range res {
		res[i] += 'a'
	}
	return string(res)
}
