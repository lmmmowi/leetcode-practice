// 278.第一个错误的版本[https://leetcode-cn.com/problems/first-bad-version/]
package main

import "fmt"

func main() {
	result := firstBadVersion(1)
	fmt.Println(result)
}

func isBadVersion(version int) bool {
	return version >= 1
}

func firstBadVersion(n int) int {
	version, head, tail := 0, 1, n

	for head <= tail {
		middle := (head + tail) / 2
		if isBadVersion(middle) {
			tail = middle - 1
			version = middle
		} else {
			head = middle + 1
		}
	}

	return version
}
