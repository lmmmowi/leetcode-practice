// 118.杨辉三角[https://leetcode-cn.com/problems/pascals-triangle/]
package main

import "fmt"

func main() {
	result := generate(10)
	for i := range result {
		for j := range result[i] {
			fmt.Print(result[i][j], " ")
		}
		fmt.Println()
	}
}

func generate(numRows int) [][]int {
	rows := make([][]int, numRows)
	for i := 0; i < numRows; i++ {
		length := i + 1
		rows[i] = make([]int, length)

		for j := 0; j < length; j++ {
			if j == 0 || j == length-1 {
				rows[i][j] = 1
			} else {
				rows[i][j] = rows[i-1][j-1] + rows[i-1][j]
			}
		}
	}
	return rows
}
