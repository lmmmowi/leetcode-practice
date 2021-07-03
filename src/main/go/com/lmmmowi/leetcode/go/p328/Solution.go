// 328.奇偶链表[https://leetcode-cn.com/problems/odd-even-linked-list/]
package main

func main() {
	head := &ListNode{1, nil}
	head.Next = &ListNode{2, nil}
	head.Next.Next = &ListNode{3, nil}
	head.Next.Next.Next = &ListNode{4, nil}
	head.Next.Next.Next.Next = &ListNode{5, nil}
	head = oddEvenList(head)

	for head != nil {
		println(head.Val)
		head = head.Next
	}
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func oddEvenList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	if head.Next == nil {
		return head
	}

	oddHead, oddTail := head, head
	evenHead, evenTail := head.Next, head.Next

	for ; ; {
		if evenTail.Next != nil {
			oddTail.Next = evenTail.Next
			oddTail = oddTail.Next
		} else {
			break
		}

		if oddTail.Next != nil {
			evenTail.Next = oddTail.Next
			evenTail = evenTail.Next
		} else {
			break
		}
	}

	oddTail.Next = evenHead
	evenTail.Next = nil
	return oddHead
}
