// 210.课程表 II[https://leetcode-cn.com/problems/course-schedule-ii/]
package main

import "fmt"

func main() {
	order := findOrder(4, [][]int{
		{1, 0},
		{2, 0},
		{3, 1},
		{3, 2},
	})
	for i := range order {
		fmt.Print(order[i], ",")
	}
}

func findOrder(numCourses int, prerequisites [][]int) []int {
	requires := make([]int, numCourses)
	for i := range prerequisites {
		m := prerequisites[i][0]
		requires[m] += 1
	}

	order := make([]int, 0)
	for len(order) < numCourses {
		k := -1
		for i := range requires {
			if requires[i] == 0 {
				k = i
				break
			}
		}

		if k == -1 {
			return []int{}
		}

		for i := range prerequisites {
			if prerequisites[i][1] == k {
				m := prerequisites[i][0]
				requires[m] -= 1
			}
		}

		order = append(order, k)
		requires[k] = -1
	}

	return order
}
