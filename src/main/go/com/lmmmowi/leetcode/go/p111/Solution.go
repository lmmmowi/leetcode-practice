// 111.二叉树的最小深度[https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/]
package main

import (
	"container/list"
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := &TreeNode{3, nil, nil}
	root.Left = &TreeNode{9, nil, nil}
	root.Right = &TreeNode{20, nil, nil}
	root.Right.Left = &TreeNode{15, nil, nil}
	root.Right.Right = &TreeNode{7, nil, nil}

	depth := minDepth(root)
	fmt.Print(depth)
}

func minDepth(root *TreeNode) int {
	depth := 0
	queue := list.New()
	if root != nil {
		queue.PushBack(root)
	}

	for queue.Len() > 0 {
		depth++

		n := queue.Len()
		for i := 0; i < n; i++ {
			element := queue.Front()
			queue.Remove(element)
			node := element.Value.(*TreeNode)

			if node.Left == nil && node.Right == nil {
				return depth
			}

			if node.Left != nil {
				queue.PushBack(node.Left)
			}
			if node.Right != nil {
				queue.PushBack(node.Right)
			}
		}
	}

	return 0
}
