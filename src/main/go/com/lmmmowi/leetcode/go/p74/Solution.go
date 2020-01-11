// 74.搜索二维矩阵[https://leetcode-cn.com/problems/search-a-2d-matrix/]
package main

func main() {
	searchMatrix([][]int{
		{1, 3, 5, 7},
		{10, 11, 16, 20},
		{23, 30, 34, 50},
	}, 3)
}

func searchMatrix(matrix [][]int, target int) bool {
	row := len(matrix)
	if row == 0 {
		return false
	}

	col := len(matrix[0])
	head := 0
	tail := row*col - 1

	for head <= tail {
		index := (head + tail) / 2
		r := index / col
		c := index % col

		val := matrix[r][c]
		if matrix[r][c] == target {
			return true
		} else if val < target {
			head = index + 1
		} else {
			tail = index - 1
		}
	}

	return false
}
