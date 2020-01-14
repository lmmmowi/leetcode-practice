// 105.从前序与中序遍历序列构造二叉树[https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/]
package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	tree := buildTree([]int{3, 9, 20, 15, 7}, []int{9, 3, 15, 20, 7})
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

func buildTree(preorder []int, inorder []int) *TreeNode {
	l := len(preorder)
	if l == 0 {
		return nil
	}

	rootVal := preorder[0]
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
		root.Left = buildTree(preorder[1:1+leftLen], inorder[:leftLen])
	}
	if rightLen > 0 {
		root.Right = buildTree(preorder[1+leftLen:], inorder[leftLen+1:])
	}
	return root
}
