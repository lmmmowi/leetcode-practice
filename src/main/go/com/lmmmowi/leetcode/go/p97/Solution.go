// 97.交错字符串[https://leetcode-cn.com/problems/interleaving-string/]
package main

import "fmt"

func main() {
	ok := isInterleave("a", "b", "a")
	fmt.Print(ok)
}

func isInterleave(s1 string, s2 string, s3 string) bool {
	l1, l2, l3 := len(s1), len(s2), len(s3)
	if l1+l2 != l3 {
		return false
	}

	// flags[i][j]表示：由s1的前j个字符，与s2的前(i-j)，是否能够交错组成s3的前i个字符
	// flags[i][j] = flags[i-1][j-1] && s1[j-1]==s3[i-1] 或者 flags[i-1][j] && s2[i-j-1]==s3[i-1]
	flags := make([][]bool, l3+1)
	for i := range flags {
		flags[i] = make([]bool, l1+1)
	}
	flags[0][0] = true

	for i := 1; i <= l3; i++ {
		for j := 0; j <= i && j <= l1; j++ {
			ok := i-j > 0 && i-j <= l2 && flags[i-1][j] && s2[i-j-1] == s3[i-1]
			if !ok {
				ok = j > 0 && flags[i-1][j-1] && s1[j-1] == s3[i-1]
			}
			flags[i][j] = ok
		}
	}

	return flags[l3][l1]
}
