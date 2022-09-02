// 383. 赎金信[https://leetcode.cn/problems/ransom-note/]
package main

func canConstruct(ransomNote string, magazine string) bool {
	arr := make([]int, 256)
	for _, c := range magazine {
		arr[c] ++
	}
	for _, c := range ransomNote {
		arr[c] --
		if arr[c] < 0 {
			return false
		}
	}
	return true
}
