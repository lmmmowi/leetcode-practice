// 236. 二叉树的最近公共祖先[https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/]
package main

import "fmt"

func main() {
	root := &TreeNode{3, nil, nil}
	root.Left = &TreeNode{5, nil, nil}
	root.Right = &TreeNode{1, nil, nil}
	root.Left.Left = &TreeNode{6, nil, nil}
	root.Left.Right = &TreeNode{2, nil, nil}
	root.Right.Left = &TreeNode{0, nil, nil}
	root.Right.Right = &TreeNode{8, nil, nil}
	root.Left.Right.Left = &TreeNode{7, nil, nil}
	root.Left.Right.Right = &TreeNode{4, nil, nil}
	a := lowestCommonAncestor(root, root.Left, root.Left.Right.Right)
	fmt.Println(a.Val)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	result := make(chan *TreeNode)
	go find(root, p, q, result)
	return <-result
}

func find(root, p, q *TreeNode, result chan *TreeNode) int {
	if root == nil {
		return 0
	}

	found := 0
	if p.Val == root.Val || q.Val == root.Val {
		found++
	}

	found += find(root.Left, p, q, result)
	found += find(root.Right, p, q, result)

	if found == 2 {
		result <- root
	}

	return found
}
