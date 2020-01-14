// 106.从中序与后序遍历序列构造二叉树[https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/]
package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	tree := buildTree([]int{9, 3, 15, 20, 7}, []int{9, 15, 7, 20, 3})
	printTree(tree)
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

func buildTree(inorder []int, postorder []int) *TreeNode {
	l := len(inorder)
	if l == 0 {
		return nil
	}

	rootVal := postorder[l-1]
	var rootIndex int
	for i := 0; i < len(inorder); i++ {
		if inorder[i] == rootVal {
			rootIndex = i
			break
		}
	}

	leftLen := rootIndex
	rightLen := l - 1 - leftLen

	root := &TreeNode{rootVal, nil, nil}
	if leftLen > 0 {
		root.Left = buildTree(inorder[:leftLen], postorder[:leftLen])
	}
	if rightLen > 0 {
		root.Right = buildTree(inorder[leftLen+1:], postorder[leftLen:])
	}
	return root
}
