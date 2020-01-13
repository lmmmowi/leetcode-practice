// 96.不同的二叉搜索树[https://leetcode-cn.com/problems/unique-binary-search-trees/]
package main

import "fmt"

func main() {
	num := numTrees(18)
	fmt.Print(num)
}

func numTrees(n int) int {
	return getNumTrees(n, 1, n, make([]int, n))
}

func getNumTrees(n int, begin int, end int, cache []int) int {
	if cache[end-begin] > 0 {
		return cache[end-begin]
	}

	num := 0
	for val := begin; val <= end; val++ {
		var leftTrees int
		if val-1 >= begin {
			leftTrees = getNumTrees(n, begin, val-1, cache)
		} else {
			leftTrees = 1
		}

		var rightTrees int
		if val+1 <= end {
			rightTrees = getNumTrees(n, val+1, end, cache)
		} else {
			rightTrees = 1
		}

		num += leftTrees * rightTrees
	}

	cache[end-begin] = num
	return num
}
