// 66.加一[https://leetcode-cn.com/problems/plus-one/]
package p66

func plusOne(digits []int) []int {
	var plus = 1
	for i := len(digits) - 1; i >= 0; i-- {
		tmp := plus + digits[i]
		plus = tmp / 10
		digits[i] = tmp % 10
	}

	if (plus > 0) {
		digits = append([]int{1}, digits...)
	}
	return digits
}