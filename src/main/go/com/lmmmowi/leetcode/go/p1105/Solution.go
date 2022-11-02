package main

import "fmt"

func main() {
	books := [][]int{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}
	res := minHeightShelves(books, 4)
	fmt.Println(res)
}

func minHeightShelves(books [][]int, shelfWidth int) int {
	n := len(books)
	dp := make([]int, n+1)

	for i := 1; i <= n; i++ {
		dp[i] = 99999999
		w := 0
		h := 0
		for j := i; j > 0; j-- {
			w += books[j-1][0]
			if w > shelfWidth {
				break
			}

			h = max(books[j-1][1], h)
			dp[i] = min(dp[i], dp[j-1]+h)
		}
	}

	return dp[n]
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
