// 206.反转链表[https://leetcode-cn.com/problems/reverse-linked-list/]
package main

func main() {
	head := &ListNode{1, nil}
	head.Next = &ListNode{2, nil}
	head.Next.Next = &ListNode{3, nil}
	head.Next.Next.Next = &ListNode{4, nil}
	head.Next.Next.Next.Next = &ListNode{5, nil}
	head = reverseList(head)

	for head != nil {
		println(head.Val)
		head = head.Next
	}
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	head, _ = reverseListWithTuple(head)
	return head
}

func reverseListWithTuple(head *ListNode) (*ListNode, *ListNode) {
	if head.Next == nil {
		return head, head
	}

	h, t := reverseListWithTuple(head.Next)
	t.Next = head
	head.Next = nil
	return h, head
}
