// 2058. 找出临界点之间的最小和最大距离[https://leetcode.cn/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/]
package main

import "fmt"

func main() {
	arr := []int{2,3,3,2}

	head := &ListNode{arr[0], nil}
	node := head
	for i := 1; i < len(arr); i++ {
		node.Next = &ListNode{arr[i], nil}
		node = node.Next
	}

	res := nodesBetweenCriticalPoints(head)
	fmt.Println(res[0], res[1])
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func nodesBetweenCriticalPoints(head *ListNode) []int {
	minDistance := -1
	maxDistance := -1

	firstCriticalIndex := -1
	lastCriticalIndex := -1
	index := 0
	prevVal := head.Val
	node := head
	for node.Next != nil {
		node = node.Next
		index++

		if isCriticalNode(node, prevVal) {
			if firstCriticalIndex == -1 {
				firstCriticalIndex = index
			}

			if lastCriticalIndex >= 0 {
				if minDistance == -1 || index-lastCriticalIndex < minDistance {
					minDistance = index - lastCriticalIndex
				}

				maxDistance = index - firstCriticalIndex
			}
			lastCriticalIndex = index
		}

		prevVal = node.Val
	}

	return []int{minDistance, maxDistance}
}

func isCriticalNode(node *ListNode, prevVal int) bool {
	if node.Next == nil {
		return false
	} else {
		return (node.Val-prevVal)*(node.Val-node.Next.Val) > 0
	}
}
