// 94.二叉树的中序遍历[https://leetcode-cn.com/problems/binary-tree-inorder-traversal/]
package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := &TreeNode{1, nil, nil}
	root.Right = &TreeNode{2, nil, nil}
	root.Right.Left = &TreeNode{3, nil, nil}

	val := inorderTraversal(root)
	for i := range val {
		fmt.Print(val[i], ",")
	}
}

func inorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	return doInorderTraversal(root, make([]int, 0))
}

func doInorderTraversal(root *TreeNode, val []int) []int {
	if root.Left != nil {
		val = doInorderTraversal(root.Left, val)
	}
	val = append(val, root.Val)
	if root.Right != nil {
		val = doInorderTraversal(root.Right, val)
	}
	return val
}
