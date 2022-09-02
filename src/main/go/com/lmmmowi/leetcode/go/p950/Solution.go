// 950. 按递增顺序显示卡牌[https://leetcode.cn/problems/reveal-cards-in-increasing-order/]
package main

import (
	"container/list"
	"sort"
)

func deckRevealedIncreasing(deck []int) []int {
	sort.Sort(sort.Reverse(sort.IntSlice(deck)))

	queue := list.List{}
	for _, v := range deck {
		if queue.Len() > 0 {
			queue.MoveToFront(queue.Back())
		}
		queue.PushFront(v)
	}

	result := make([]int, queue.Len())
	for i := range result {
		result[i] = queue.Remove(queue.Front()).(int)
	}

	return result
}
