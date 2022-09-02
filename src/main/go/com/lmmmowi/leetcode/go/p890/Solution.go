// 890. 查找和替换模式[https://leetcode.cn/problems/find-and-replace-pattern/]
package main

func findAndReplacePattern(words []string, pattern string) []string {
	var result []string
	mapping := make([]uint8, 256)
	mappingReversed := make([]uint8, 256)

	for _, word := range words {
		reset(mapping)
		reset(mappingReversed)

		match := true
		for i := range pattern {
			p := pattern[i]
			w := word[i]

			if mapping[p] == 0 && mappingReversed[w] == 0 {
				mapping[p] = w
				mappingReversed[w] = p
			}

			if mapping[p] != w {
				match = false
				break
			}
		}

		if match {
			result = append(result, word)
		}
	}

	return result
}

func reset(mapping []uint8) {
	for i := range mapping {
		mapping[i] = 0
	}
}