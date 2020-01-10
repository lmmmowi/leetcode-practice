// 107.二叉树的层次遍历 II[https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/]
package main

import (
	"container/list"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	p := &TreeNode{1, nil, nil}
	p.Left = &TreeNode{2, nil, nil}
	p.Right = &TreeNode{3, nil, nil}
	p.Right.Left = &TreeNode{4, nil, nil}

	arr := levelOrderBottom(p)
	for i := range arr {
		for j := range arr[i] {
			print(arr[i][j])
		}
		println()
	}
}

func levelOrderBottom(root *TreeNode) [][]int {
	queue := list.New()
	if root != nil {
		queue.PushBack(root)
	}

	// 广度优先遍历
	resultArray := make([][]int, 0)
	for queue.Len() > 0 {
		values := make([]int, 0)

		n := queue.Len()
		for ; n > 0; n-- {
			element := queue.Front()
			queue.Remove(element)

			node := element.Value.(*TreeNode)
			values = append(values, node.Val)

			if node.Left != nil {
				queue.PushBack(node.Left)
			}

			if node.Right != nil {
				queue.PushBack(node.Right)
			}
		}

		resultArray = append(resultArray, values)
	}

	// 反转数组
	length := len(resultArray)
	for i := 0; i < length/2; i++ {
		temp := resultArray[i]
		resultArray[i] = resultArray[length-i-1]
		resultArray[length-i-1] = temp
	}

	return resultArray
}
