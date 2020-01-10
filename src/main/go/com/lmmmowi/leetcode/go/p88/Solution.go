// 88. 合并两个有序数组[https://leetcode-cn.com/problems/merge-sorted-array/]
package main

func main() {
	nums1 := []int{1, 2, 3, 0, 0, 0}
	nums2 := []int{2, 5, 6}
	merge(nums1, 3, nums2, 3)

	for e := range nums1 {
		print(nums1[e])
	}
}

func merge(nums1 []int, m int, nums2 []int, n int) {
	k := m + n
	for k > 0 {
		if m > 0 && n > 0 {
			if nums1[m-1] > nums2[n-1] {
				m -= 1
				nums1[k-1] = nums1[m]
			} else {
				n -= 1
				nums1[k-1] = nums2[n]
			}
		} else if m > 0 {
			m -= 1
			nums1[k-1] = nums1[m]
		} else if n > 0 {
			n -= 1
			nums1[k-1] = nums2[n]
		}

		k -= 1
	}
}
