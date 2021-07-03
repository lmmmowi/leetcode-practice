// 445.两数相加 II[https://leetcode-cn.com/problems/add-two-numbers-ii/]
package main

func main() {
	l1 := &ListNode{9, nil}
	l1.Next = &ListNode{4, nil}
	l1.Next.Next = &ListNode{4, nil}
	l1.Next.Next.Next = &ListNode{3, nil}

	l2 := &ListNode{5, nil}
	l2.Next = &ListNode{6, nil}
	l2.Next.Next = &ListNode{4, nil}

	res := addTwoNumbers(l1, l2)

	for res != nil {
		println(res.Val)
		res = res.Next
	}
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	l1 = reverse(l1)
	l2 = reverse(l2)

	var res, cur *ListNode
	increment := 0
	for ; l1 != nil || l2 != nil || increment > 0; {
		node := &ListNode{0, nil}
		if l1 != nil {
			node.Val += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			node.Val += l2.Val
			l2 = l2.Next
		}
		node.Val += increment
		increment = node.Val / 10
		node.Val %= 10

		if cur == nil {
			res = node
			cur = node
		} else {
			cur.Next = node
			cur = node
		}
	}

	return reverse(res)
}

func reverse(l *ListNode) *ListNode {
	if l.Next == nil {
		return l
	} else {
		head := reverse(l.Next)
		l.Next.Next = l
		l.Next = nil
		return head
	}
}