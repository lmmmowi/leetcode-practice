// 129.求根到叶子节点数字之和[https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/]
package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := &TreeNode{4, nil, nil}
	root.Left = &TreeNode{9, nil, nil}
	root.Left.Left = &TreeNode{5, nil, nil}
	root.Left.Right = &TreeNode{1, nil, nil}
	root.Right = &TreeNode{0, nil, nil}
	sum := sumNumbers(root)
	fmt.Print(sum)
}

func sumNumbers(root *TreeNode) int {
	return sumNumbers2(root, 0)
}

func sumNumbers2(root *TreeNode, value int) int {
	if root == nil {
		return 0
	}

	sum := value*10 + root.Val
	if root.Left == nil && root.Right == nil {
		return sum
	}

	left := sumNumbers2(root.Left, sum)
	right := sumNumbers2(root.Right, sum)
	return left + right
}
