// 257.二叉树的所有路径[https://leetcode-cn.com/problems/binary-tree-paths/]
package main

import (
	"container/list"
	"fmt"
	"strconv"
)

func main() {
	root := &TreeNode{1, nil, nil}
	root.Left = &TreeNode{2, nil, nil}
	root.Right = &TreeNode{3, nil, nil}
	root.Left.Right = &TreeNode{5, nil, nil}
	result := binaryTreePaths(root)
	fmt.Println(result)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func binaryTreePaths(root *TreeNode) []string {
	return findPath(root, list.New(), make([]string, 0))
}

func findPath(node *TreeNode, nodes *list.List, paths []string) []string {
	if node != nil {
		element := nodes.PushBack(node.Val)
		defer nodes.Remove(element)

		if node.Left == nil && node.Right == nil {
			s := nodesToStr(nodes)
			paths = append(paths, s)
		} else {
			if node.Left != nil {
				paths = findPath(node.Left, nodes, paths)
			}

			if node.Right != nil {
				paths = findPath(node.Right, nodes, paths)
			}
		}
	}

	return paths
}

func nodesToStr(nodes *list.List) string {
	node := nodes.Front()
	s := strconv.Itoa(node.Value.(int))
	for i := node.Next(); i != nil; i = i.Next() {
		s += "->" + strconv.Itoa(i.Value.(int))
	}
	return s
}
