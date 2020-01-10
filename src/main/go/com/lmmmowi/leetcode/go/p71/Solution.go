// 71.简化路径[https://leetcode-cn.com/problems/simplify-path/]
package main

import (
	"container/list"
	"fmt"
	"strings"
)

func main() {
	s := simplifyPath("/home/")
	fmt.Println(s)
}

func simplifyPath(path string) string {
	stack := list.New()

	parts := strings.Split(path, "/")
	for i := range parts {
		part := parts[i]
		if len(part) == 0 || "." == part {
			// do nothing
		} else if ".." == part {
			element := stack.Back()
			if element != nil {
				stack.Remove(element)
			}
		} else {
			stack.PushBack(part)
		}
	}

	arr := make([]string, stack.Len())
	for i := 0; i < len(arr); i++ {
		element := stack.Front()
		stack.Remove(element)
		arr[i] = element.Value.(string)
	}

	return "/" + strings.Join(arr, "/")
}
