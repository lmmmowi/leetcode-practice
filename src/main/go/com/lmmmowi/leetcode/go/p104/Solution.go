// 104.二叉树的最大深度[https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/]
package main

func main() {
	p := &TreeNode{1, nil, nil}
	p.Left = &TreeNode{2, nil, nil}
	p.Right = &TreeNode{3, nil, nil}
	p.Right.Left = &TreeNode{4, nil, nil}

	print(maxDepth(p))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	l := 1 + maxDepth(root.Left)
	r := 1 + maxDepth(root.Right)

	if l > r {
		return l
	} else {
		return r
	}
}
