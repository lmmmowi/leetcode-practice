// 67. 二进制求和[https://leetcode-cn.com/problems/add-binary/]
package p67

import (
	"strconv"
)

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func append(str string, i int) string {
	return strconv.Itoa(i) + str
}

func addBinary(a string, b string) string {
	var lenA = len(a)
	var lenB = len(b)
	var len = max(lenA, lenB)

	str := ""
	extra := 0
	for i := 0; i < len; i++ {
		elementA := 0
		if lenA > i {
			elementA, _ = strconv.Atoi(string(a[lenA-i-1]))
		}

		elementB := 0
		if lenB > i {
			elementB, _ = strconv.Atoi(string(b[lenB-i-1]))
		}

		k := elementA + elementB + extra
		if k >= 2 {
			extra = 1
		} else {
			extra = 0
		}

		str = append(str, k%2)
	}

	if extra > 0 {
		str = append(str, 1)
	}

	return str
}