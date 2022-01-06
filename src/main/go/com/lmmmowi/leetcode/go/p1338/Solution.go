// 1338. 数组大小减半[https://leetcode-cn.com/problems/reduce-array-size-to-the-half/]
package main

func minSetSize(arr []int) int {
	countMap := make(map[int]int)
	for _, num := range arr {
		countMap[num]++
	}

	counts := make([]int, len(countMap))
	i := 0
	for _, count := range countMap {
		counts[i] = count
		i++
	}

	initSorting(counts)
	for i := len(counts) - 1; i >= 0; i-- {
		temp := counts[0]
		counts[0] = counts[i]
		counts[i] = temp
		sort(counts, 0, i)
	}

	chosen := 0
	sum := 0
	half := (len(arr) + 1) / 2
	for ; sum < half; {
		sum += counts[chosen]
		chosen++
	}

	return chosen
}

func initSorting(counts []int) {
	length := len(counts)
	for i := length - 1; i >= 0; i-- {
		sort(counts, i, length)
	}
}

func sort(counts []int, parent int, length int) {
	parentValue := counts[parent]
	child := parent*2 + 1

	for ; child < length; {
		if child+1 < length && counts[child] > counts[child+1] {
			child++
		}

		if parentValue < counts[child] {
			break
		}

		counts[parent] = counts[child]
		parent = child
		child = parent*2 + 1
	}

	counts[parent] = parentValue
}
