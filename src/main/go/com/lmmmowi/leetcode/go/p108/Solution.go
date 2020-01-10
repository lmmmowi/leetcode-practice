// 108.将有序数组转换为二叉搜索树[https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/]
package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	sortedArrayToBST([]int{-10, -3, 0, 5, 9})
}

func sortedArrayToBST(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	} else if len(nums) == 1 {
		return &TreeNode{nums[0], nil, nil}
	} else{
		middle := (0 + len(nums)) / 2
		left := sortedArrayToBST(nums[:middle])
		right := sortedArrayToBST(nums[middle+1:])
		return &TreeNode{nums[middle], left, right}
	}
}
