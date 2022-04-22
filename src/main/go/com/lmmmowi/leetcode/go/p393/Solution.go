// 393. UTF-8 编码验证[https://leetcode-cn.com/problems/utf-8-validation/]
package main

const byte10000000 int = 0x80
const byte11000000 int = 0xC0

func validUtf8(data []int) bool {
	n := len(data)
	ptr := 0

	for ptr < n {
		firstByte := data[ptr]
		ptr++
		if (firstByte & byte10000000) == 0 {
			continue
		}

		length := detectBytesLength(firstByte)
		if length <= 1 || length > 4 {
			return false
		}

		for i := 0; i < length-1; i++ {
			if ptr >= n || (data[ptr]&byte11000000) != byte10000000 {
				return false
			}
			ptr++
		}
	}

	return true
}

func detectBytesLength(b int) int {
	length := 0
	for (b & byte10000000) > 0 {
		length++
		b <<= 1
	}
	return length
}
