// 86.分隔链表[https://leetcode-cn.com/problems/partition-list/]
package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	head := &ListNode{1, nil}
	head.Next = &ListNode{4, nil}
	head.Next.Next = &ListNode{3, nil}
	head.Next.Next.Next = &ListNode{2, nil}
	head.Next.Next.Next.Next = &ListNode{5, nil}
	head.Next.Next.Next.Next.Next = &ListNode{2, nil}

	head = partition(head, 3)

	for node := head; node != nil; node = node.Next {
		fmt.Print(node.Val, ",")
	}
}

func partition(head *ListNode, x int) *ListNode {
	var lhead, ltail, ghead, gtail *ListNode

	for node := head; node != nil; node = node.Next {
		if node.Val < x {
			if lhead == nil {
				lhead = node
			}
			if ltail != nil {
				ltail.Next = node
			}
			ltail = node
		} else {
			if ghead == nil {
				ghead = node
			}
			if gtail != nil {
				gtail.Next = node
			}
			gtail = node
		}
	}

	if ltail != nil {
		ltail.Next = ghead
	}
	if gtail != nil {
		gtail.Next = nil
	}
	if lhead != nil {
		head = lhead
	} else {
		head = ghead
	}

	return head
}
