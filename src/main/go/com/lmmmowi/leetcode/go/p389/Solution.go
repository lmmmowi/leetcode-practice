// 389. 找不同[https://leetcode-cn.com/problems/find-the-difference/]
package main

func findTheDifference(s string, t string) byte {
	arr := [26]int{}

	for i := 0; i < len(t); i++ {
		arr[t[i] - 'a']++
	}

	for i := 0; i < len(s); i++ {
		arr[s[i] - 'a']--
	}

	for i, val := range arr {
		if val == 1 {
			return (byte)(i + 'a')
		}
	}

	return 0
}
