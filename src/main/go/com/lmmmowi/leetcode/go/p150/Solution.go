// 150.逆波兰表达式求值[https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/]
package main

import (
	"container/list"
	"fmt"
	"strconv"
)

func main() {
	result := evalRPN([]string{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})
	fmt.Println(result)
}

func evalRPN(tokens []string) int {
	stack := list.New()

	for i := range tokens {
		token := tokens[i]
		if isNumber(token) {
			number, _ := strconv.Atoi(token)
			stack.PushBack(number)
		} else {
			result := calc(stack, token)
			stack.PushBack(result)
		}
	}

	return stack.Front().Value.(int)
}

func isNumber(token string) bool {
	c := token[len(token)-1]
	return c >= '0' && c <= '9'
}

func calc(stack *list.List, signal string) int {
	element := stack.Back()
	b := element.Value.(int)
	stack.Remove(element)
	element = stack.Back()
	a := element.Value.(int)
	stack.Remove(element)

	switch signal {
	case "+":
		return a + b
	case "-":
		return a - b
	case "*":
		return a * b
	case "/":
		return a / b
	default:
		return 0
	}
}
