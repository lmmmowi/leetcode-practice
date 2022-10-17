// 165. 比较版本号[https://leetcode.cn/problems/compare-version-numbers/]
package main

func main() {
	compareVersion("1", "1.1")
}

func compareVersion(version1 string, version2 string) int {
	var v1, v2 int
	ptr1 := 0
	ptr2 := 0

	for ptr1 < len(version1) || ptr2 < len(version2) {
		v1, ptr1 = readPart(version1, ptr1)
		v2, ptr2 = readPart(version2, ptr2)
		if v1 > v2 {
			return 1
		}
		if v1 < v2 {
			return -1
		}
	}

	return 0
}

func readPart(version string, ptr int) (int, int) {
	val := 0
	for ptr < len(version) && version[ptr] != '.' {
		val = val*10 + int(version[ptr]-'0')
		ptr++
	}
	return val, ptr + 1
}
