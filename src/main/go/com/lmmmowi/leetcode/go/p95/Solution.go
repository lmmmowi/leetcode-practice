// 95.不同的二叉搜索树 II[https://leetcode-cn.com/problems/unique-binary-search-trees-ii/]
package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	trees := generateTrees(3)
	for i := range trees {
		printTree(trees[i])
		fmt.Println()
	}
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

func generateTrees(n int) []*TreeNode {
	return generate(n, 1, n)
}

func generate(n int, begin int, end int) []*TreeNode {
	trees := make([]*TreeNode, 0)

	for val := begin; val <= end; val++ {
		var leftTrees []*TreeNode
		if val-1 >= begin {
			leftTrees = generate(n, begin, val-1)
		} else {
			leftTrees = []*TreeNode{nil}
		}

		var rightTrees []*TreeNode
		if val+1 <= end {
			rightTrees = generate(n, val+1, end)
		} else {
			rightTrees = []*TreeNode{nil}
		}

		for i := 0; i < len(leftTrees); i++ {
			for j := 0; j < len(rightTrees); j++ {
				root := &TreeNode{val, leftTrees[i], rightTrees[j]}
				trees = append(trees, root)
			}
		}
	}

	return trees
}
