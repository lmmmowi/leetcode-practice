// 1046. 最后一块石头的重量[https://leetcode-cn.com/problems/last-stone-weight/]
package main

func lastStoneWeight(stones []int) int {
	initSorting(stones)

	count := len(stones)
	for ; count > 1; {
		max := stones[0]
		count--

		stones[0] = stones[count]
		sort(stones, 0, count)
		secondMax := stones[0]

		stones[0] = max - secondMax
		sort(stones, 0, count)

		if stones[0] == 0 {
			count--
		}
	}

	return stones[0]
}

func initSorting(stones []int) {
	length := len(stones)
	for i := length - 1; i >= 0; i-- {
		sort(stones, i, length)
	}
}

func sort(stones []int, parent int, length int) {
	parentValue := stones[parent]
	child := parent*2 + 1

	for ; child < length; {
		if child+1 < length && stones[child] < stones[child+1] {
			child++
		}

		if parentValue > stones[child] {
			break
		}

		stones[parent] = stones[child]
		parent = child
		child = parent*2 + 1
	}

	stones[parent] = parentValue
}
