// 141.环形链表[https://leetcode-cn.com/problems/linked-list-cycle/]
package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	head := &ListNode{3, nil}
	head.Next = &ListNode{2, nil}
	head.Next.Next = &ListNode{0, nil}
	head.Next.Next.Next = &ListNode{-4, nil}
	head.Next.Next.Next.Next = head.Next

	hasCycle(head)
}

func hasCycle(head *ListNode) bool {
	oneStep, twoStep := head, head

	for true {
		oneStep = move(oneStep, 1)
		twoStep = move(twoStep, 2)

		if oneStep == nil || twoStep == nil {
			return false
		}

		if oneStep == twoStep {
			return true
		}
	}

	return false
}

func move(node *ListNode, step int) *ListNode {
	for i := 0; i < step; i++ {
		if node == nil {
			return nil
		} else {
			node = node.Next
		}
	}
	return node
}
