// 100.相同的树[https://leetcode-cn.com/problems/same-tree/]
package main

func main() {
	p := &TreeNode{1, nil, nil}
	p.Left = &TreeNode{2, nil, nil}
	p.Right = &TreeNode{3, nil, nil}

	print(isSameTree(p, p))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSameTree(p *TreeNode, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	} else if p == nil || q == nil {
		return false
	}

	if p.Val != q.Val {
		return false
	}

	return isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
}
