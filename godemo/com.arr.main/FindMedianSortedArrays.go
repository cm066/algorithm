package main

func main() {

}

func FindMedianSortedArrays(nums1, nums2 []int) float64 {
	if len(nums1) > len(nums2) {
		tmp := nums1
		nums1 = nums2
		nums2 = tmp
	}
	m := len(nums1)
	n := len(nums2)
	iMin := 0
	iMax := m
	for iMin <= iMax {
		// 开始二分法
		i := (iMin + iMax) / 2
		//根据i的位置来决定j的位置
		j := (n+m+1)/2 - i
		if j != 0 && i != m && nums2[j-1] > nums1[i] {
			iMin = i + 1
		} else if j != n && i != 0 && nums1[i-1] > nums2[j] {
			iMax = i - 1
		} else {
			// 处理边界问题，已经有一个数组达到了边界，左边或者是右边
			leftMax := 0
			if i == 0 {
				leftMax = nums2[j-1]
			} else if j == 0 {
				leftMax = nums1[i-1]
			} else {
				leftMax = min(nums1[i-1], nums2[j-1])
			}
			if (m+n)%2 == 1 {
				return float64(leftMax)
			}
			minRight := 0
			if i == m {
				minRight = nums2[j]
			} else if j == n {
				minRight = nums1[i]
			} else {
				minRight = min(nums1[i], nums2[j])
			}
			return float64((minRight + leftMax) / 2)
		}
	}
	return 0
}

func min(x, y int) int {
	if x > y {
		return y
	}
	return x
}
