// 160.相交链表[https://leetcode-cn.com/problems/intersection-of-two-linked-lists/]
package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	c := &ListNode{8, nil}
	c.Next = &ListNode{4, nil}
	c.Next.Next = &ListNode{5, nil}

	a := &ListNode{4, nil}
	a.Next = &ListNode{1, nil}
	a.Next.Next = c

	b := &ListNode{5, nil}
	b.Next = &ListNode{0, nil}
	b.Next.Next = &ListNode{1, nil}
	b.Next.Next.Next = c

	node := getIntersectionNode(a, b)
	if node != nil {
		fmt.Println(node.Val)
	} else {
		fmt.Println("null")
	}
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	a, b := headA, headB
	an, bn := 0, 0

	for a != nil {
		a = a.Next
		an++
	}

	for b != nil {
		b = b.Next
		bn++
	}

	if an > bn {
		for i := 0; i < an-bn; i++ {
			headA = headA.Next
		}
	} else if bn > an {
		for i := 0; i < bn-an; i++ {
			headB = headB.Next
		}
	}

	for headA != nil {
		if headA == headB {
			return headA
		} else {
			headA = headA.Next
			headB = headB.Next
		}
	}

	return nil
}
