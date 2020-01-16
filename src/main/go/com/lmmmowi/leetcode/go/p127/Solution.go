// 127.单词接龙[https://leetcode-cn.com/problems/word-ladder/]
package main

import "fmt"

func main() {
	dis := ladderLength("hit", "cog", []string{"hot", "hit", "cog", "dot", "dog"})
	fmt.Print(dis)
}

func ladderLength(beginWord string, endWord string, wordList []string) int {
	wordList = append(wordList, beginWord)
	l := len(wordList)

	beginIndex := l - 1
	endIndex := -1
	for i := range wordList {
		if wordList[i] == endWord {
			endIndex = i
		}
	}
	if endIndex == -1 {
		return 0
	}

	// 构建图
	w := make([][]int, l)
	for i := 0; i < l; i++ {
		w[i] = make([]int, l)
		for j := 0; j < l; j++ {
			if transformEnabled(wordList[i], wordList[j]) {
				w[i][j] = 1
			} else {
				w[i][j] = l
			}
		}
	}

	// 初始化S集合
	s := make([]bool, l)
	s[beginIndex] = true
	for true {
		k := -1
		minDis := l + 1
		for i := 0; i < l; i++ {
			if !s[i] && w[beginIndex][i] < minDis {
				k = i
				minDis = w[beginIndex][i]
			}
		}

		if k >= 0 {
			s[k] = true

			// 更新起始点到各点的最短距离
			for i := 0; i < l; i++ {
				w[beginIndex][i] = min(w[beginIndex][i], w[beginIndex][k]+w[k][i])
			}
		} else {
			break
		}
	}

	dis := w[beginIndex][endIndex]
	if dis >= l {
		return 0
	} else {
		return dis + 1
	}
}

func transformEnabled(a string, b string) bool {
	if len(a) != len(b) {
		return false
	}

	diff := 0
	for i := 0; i < len(a); i++ {
		if a[i] != b[i] {
			diff++
		}
	}

	return diff == 1
}

func min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
