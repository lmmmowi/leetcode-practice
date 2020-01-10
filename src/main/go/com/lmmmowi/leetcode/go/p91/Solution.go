// 91. 解码方法[https://leetcode-cn.com/problems/decode-ways/]
package main

func numDecodings(s string) int {
	length := len(s)
	arr := make([]uint8, length)
	for i := 0; i < length; i++ {
		arr[i] = s[i] - '0'
	}

	mc := make([]int, length)
	for i := 0; i < length; i++ {
		// 一位数字的情况
		if arr[i] > 0 {
			if i == 0 {
				mc[i] = 1
			} else {
				mc[i] = mc[i-1]
			}
		} else {
			mc[i] = 0
		}

		// 两位数字的情况
		if i > 0 && arr[i-1] > 0 {
			num := arr[i] + arr[i-1]*10
			if num > 0 && num <= 26 {
				if i == 1 {
					mc[i] += 1
				} else {
					mc[i] += mc[i-2]
				}
			}
		}
	}

	return mc[length-1]
}
