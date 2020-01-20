// 113.路径总和 II[https://leetcode-cn.com/problems/path-sum-ii/]
package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := &TreeNode{5, nil, nil}
	root.Left = &TreeNode{4, nil, nil}
	root.Left.Left = &TreeNode{11, nil, nil}
	root.Left.Left.Left = &TreeNode{7, nil, nil}
	root.Left.Left.Left = &TreeNode{2, nil, nil}
	root.Right = &TreeNode{8, nil, nil}
	root.Right.Left = &TreeNode{13, nil, nil}
	root.Right.Right = &TreeNode{4, nil, nil}
	root.Right.Right.Left = &TreeNode{5, nil, nil}
	root.Right.Right.Right = &TreeNode{1, nil, nil}

	pathList := pathSum(root, 22)
	for i := range pathList {
		for j := range pathList[i] {
			fmt.Print(pathList[i][j], ",")
		}
		fmt.Println()
	}
}

func pathSum(root *TreeNode, sum int) [][]int {
	return findPath(root, sum, make([]int, 0), 0)
}

func findPath(root *TreeNode, sum int, path []int, pos int) [][]int {
	if root == nil {
		return [][]int{}
	}

	if len(path) <= pos {
		path = append(path, root.Val)
	} else {
		path[pos] = root.Val
	}

	if sum == root.Val && root.Left == nil && root.Right == nil {
		arr := make([]int, pos+1)
		copy(arr, path)
		return [][]int{arr}
	} else {
		a := findPath(root.Left, sum-root.Val, path, pos+1)
		b := findPath(root.Right, sum-root.Val, path, pos+1)
		return combine(a, b)
	}
}

func combine(a, b [][]int) [][]int {
	c := make([][]int, len(a)+len(b))
	n := 0
	for i := range a {
		c[n] = a[i]
		n++
	}
	for i := range b {
		c[n] = b[i]
		n++
	}
	return c
}
