// 142.环形链表 II[https://leetcode-cn.com/problems/linked-list-cycle-ii/]
package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	head := &ListNode{3, nil}
	head.Next = &ListNode{2, nil}
	head.Next.Next = &ListNode{0, nil}
	head.Next.Next.Next = &ListNode{-4, nil}
	head.Next.Next.Next = head.Next

	entrance := detectCycle(head)
	if entrance != nil {
		fmt.Println(entrance.Val)
	}
}

func detectCycle(head *ListNode) *ListNode {
	fast, slow := head, head

	begin := false
	for !begin || fast != slow {
		begin = true

		for i := 0; i < 2; i++ {
			if fast != nil {
				fast = fast.Next
			} else {
				return nil
			}
		}
		slow = slow.Next
	}

	fast = head
	for fast != slow {
		fast = fast.Next
		slow = slow.Next
	}

	return fast
}
