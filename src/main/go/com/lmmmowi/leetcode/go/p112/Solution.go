// 112.路径总和[https://leetcode-cn.com/problems/path-sum/]
package main

func main() {

}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func hasPathSum(root *TreeNode, sum int) bool {
	if root == nil {
		return false
	}

	isLeaf := root.Left == nil && root.Right == nil
	if isLeaf {
		return root.Val == sum
	} else {
		result := root.Left != nil && hasPathSum(root.Left, sum-root.Val)
		result = result || (root.Right != nil && hasPathSum(root.Right, sum-root.Val))
		return result
	}
}
