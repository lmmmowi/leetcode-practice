// 92.反转链表 II[https://leetcode-cn.com/problems/reverse-linked-list-ii/]
package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	head := &ListNode{1, nil}
	head.Next = &ListNode{2, nil}
	head.Next.Next = &ListNode{3, nil}
	head.Next.Next.Next = &ListNode{4, nil}
	head.Next.Next.Next.Next = &ListNode{5, nil}

	head = reverseBetween(head, 2, 4)

	for node := head; node != nil; node = node.Next {
		fmt.Print(node.Val, ",")
	}
}

func reverseBetween(head *ListNode, m int, n int) *ListNode {
	var tx, th, tt *ListNode

	node := head
	for k := 1; node != nil; k++ {
		if k < m {
			tx = node
		}

		next := node.Next

		if k >= m && k <= n {
			if k == m {
				tt = node
				tt.Next = nil
			} else {
				node.Next = th
			}

			th = node
		}

		if k == n {
			tt.Next = next

			if tx != nil {
				tx.Next = node
			} else {
				head = th
			}
			break
		} else {
			node = next
		}
	}

	return head
}
