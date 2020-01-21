// 114.二叉树展开为链表[https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/]
package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := &TreeNode{1, nil, nil}
	root.Left = &TreeNode{2, nil, nil}
	root.Left.Left = &TreeNode{3, nil, nil}
	root.Left.Right = &TreeNode{4, nil, nil}
	root.Right = &TreeNode{5, nil, nil}
	root.Right.Right = &TreeNode{6, nil, nil}

	flattenTree(root)
	printTree(root)
}

func printTree(tree *TreeNode) {
	if tree == nil {
		fmt.Print("null", ",")
		return
	} else {
		fmt.Print(tree.Val, ",")
	}

	printTree(tree.Left)
	printTree(tree.Right)
}

func flatten(root *TreeNode) {
	flattenTree(root)
}

func flattenTree(root *TreeNode) (*TreeNode, *TreeNode) {
	if root == nil {
		return nil, nil
	}

	lhead, ltail := flattenTree(root.Left)
	rhead, rtail := flattenTree(root.Right)

	if lhead != nil {
		root.Right = lhead
		ltail.Right = rhead
	} else {
		root.Right = rhead
	}
	root.Left = nil

	tail := root
	if rtail != nil {
		tail = rtail
	} else if ltail != nil {
		tail = ltail
	}
	return root, tail
}
