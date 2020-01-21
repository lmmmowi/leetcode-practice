// 109.有序链表转换二叉搜索树[https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/]
package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	list := &ListNode{-10, nil}
	list.Next = &ListNode{-3, nil}
	list.Next.Next = &ListNode{0, nil}
	list.Next.Next.Next = &ListNode{5, nil}
	list.Next.Next.Next.Next = &ListNode{9, nil}

	root := sortedListToBST(list)
	printTree(root)
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

func sortedListToBST(head *ListNode) *TreeNode {
	arr := make([]int, 0)
	for ; head != nil; head = head.Next {
		arr = append(arr, head.Val)
	}

	return sortedArrayToBST(arr, 0, len(arr)-1)
}

func sortedArrayToBST(arr []int, head, tail int) *TreeNode {
	if head > tail {
		return nil
	}

	middle := (head + tail) / 2
	node := &TreeNode{arr[middle], nil, nil}
	node.Left = sortedArrayToBST(arr, head, middle-1)
	node.Right = sortedArrayToBST(arr, middle+1, tail)
	return node
}
