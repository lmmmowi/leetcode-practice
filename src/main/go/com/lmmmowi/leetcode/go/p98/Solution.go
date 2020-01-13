// 98.验证二叉搜索树[https://leetcode-cn.com/problems/validate-binary-search-tree/]
package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := &TreeNode{5, nil, nil}
	root.Left = &TreeNode{1, nil, nil}
	root.Right = &TreeNode{4, nil, nil}
	root.Right.Left = &TreeNode{3, nil, nil}
	root.Right.Right = &TreeNode{6, nil, nil}

	valid := isValidBST(root)
	fmt.Print(valid)
}

func isValidBST(root *TreeNode) bool {
	preVal := -1
	begin := false
	return travel(root, &preVal, &begin)
}

func travel(node *TreeNode, preVal *int, begin *bool) bool {
	if node == nil {
		return true
	}

	if !travel(node.Left, preVal, begin) {
		return false
	}

	if !*begin || node.Val > *preVal {
		*begin = true
		*preVal = node.Val
		return travel(node.Right, preVal, begin)
	} else {
		return false
	}
}
