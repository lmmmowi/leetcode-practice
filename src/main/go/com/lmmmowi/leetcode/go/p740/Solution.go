// 740. 删除并获得点数[https://leetcode-cn.com/problems/delete-and-earn/]
package main

func deleteAndEarn(nums []int) int {
	m := 0
	numMap := make(map[int]int)
	for _, v := range nums {
		numMap[v] += v
		m = max(v, m)
	}

	dp1 := make([]int, m+1)
	dp2 := make([]int, m+1)
	for i := 1; i <= m; i++ {
		if numMap[i] > 0 {
			dp1[i] = dp2[i-1] + numMap[i]
			dp2[i] = max(dp1[i-1], dp2[i-1])
		} else {
			dp1[i] = max(dp1[i-1], dp2[i-1])
			dp2[i] = dp1[i]
		}
	}
	return max(dp1[m], dp2[m])
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
