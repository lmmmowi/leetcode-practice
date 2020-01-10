// 119.杨辉三角 II[https://leetcode-cn.com/problems/pascals-triangle-ii/]
package main

import "fmt"

func main() {
	result := getRow(3)
	for i := range result {
		fmt.Print(result[i], " ")
	}
}

func getRow(rowIndex int) []int {
	row := make([]int, rowIndex)
	row[0] = 1

	for i := 1; i < rowIndex+1; i++ {
		length := i + 1
		row[0] = 1
		row[length-1] = 1

		lastValue := 1
		for j := 1; j < length-1; j++ {
			temp := lastValue + row[j]
			lastValue = row[j]
			row[j] = temp
		}
	}

	return row
}
