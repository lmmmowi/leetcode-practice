// 68.文本左右对齐[https://leetcode-cn.com/problems/text-justification/]
package main

import (
	"container/list"
	"fmt"
)

func main() {
	lines := fullJustify([]string{"What", "must", "be", "acknowledgment", "shall", "be"}, 16)
	for i := range lines {
		fmt.Println(lines[i])
	}
}

func fullJustify(words []string, maxWidth int) []string {
	pos := 0
	width := 0
	blank := 0
	lineWords := list.New()
	lines := make([]string, 0)

	for pos < len(words) {
		word := words[pos]
		checkLength := len(word)
		if lineWords.Len() > 0 {
			checkLength += 1
		}

		// 如果剩余足够长度
		if maxWidth-width >= checkLength {
			width += checkLength
			pos++
			if lineWords.Len() > 0 {
				blank++
			}
			lineWords.PushBack(word)
		} else {
			var line string
			if lineWords.Len() == 1 {
				line = buildLastLine(lineWords, maxWidth)
			} else {
				line = buildCommonLine(lineWords, maxWidth-width+blank, blank)
			}

			lines = append(lines, line)
			width = 0
			blank = 0
		}
	}

	lines = append(lines, buildLastLine(lineWords, maxWidth))
	return lines
}

func buildCommonLine(words *list.List, blankWidth int, blank int) string {
	minBlankWidth := blankWidth / blank
	longerBlank := blankWidth % blank

	s := ""
	for words.Len() > 0 {
		element := words.Front()
		words.Remove(element)
		word := element.Value.(string)
		s += word

		if words.Len() > 0 {
			count := minBlankWidth
			if longerBlank > 0 {
				count += 1
				longerBlank--
			}
			for j := 0; j < count; j++ {
				s += " "
			}
		}
	}
	return s
}

func buildLastLine(words *list.List, maxWidth int) string {
	s := ""
	for words.Len() > 0 {
		element := words.Front()
		words.Remove(element)
		word := element.Value.(string)
		s += word
		if words.Len() > 0 {
			s += " "
		}
	}

	m := maxWidth - len(s)
	for i := 0; i < m; i++ {
		s += " "
	}
	return s
}
