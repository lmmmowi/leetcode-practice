// 110.平衡二叉树[https://leetcode-cn.com/problems/balanced-binary-tree/]
package main

import (
	"fmt"
	"math"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := &TreeNode{3, nil, nil}
	root.Left = &TreeNode{9, nil, nil}
	root.Left.Left = &TreeNode{19, nil, nil}
	root.Left.Left.Left = &TreeNode{29, nil, nil}
	root.Right = &TreeNode{20, nil, nil}
	root.Right.Right = &TreeNode{15, nil, nil}
	root.Right.Right.Right = &TreeNode{7, nil, nil}

	result := isBalanced(root)
	fmt.Println(result)
}

func isBalanced(root *TreeNode) bool {
	return getTreeHeight(root) >= 0
}

func getTreeHeight(root *TreeNode) int {
	if root == nil {
		return 0
	}

	left := getTreeHeight(root.Left)
	right := getTreeHeight(root.Right)

	if left == -1 || right == -1 || math.Abs(float64(left-right)) > 1 {
		return -1
	} else {
		return 1 + max(left, right)
	}
}

func max(x, y int) int {
	if x > y {
		return x
	} else {
		return y
	}
}
