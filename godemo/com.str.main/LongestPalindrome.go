package main

func main() {

}

func LongestPalindrome(s string) string {
	if s == nil || len(s) < 1 {
		return ""
	}
	start := 0
	end := 0
	for i := 0; i < len(s); i++ {
		l1 := expandAroundCenter(s, i, i)
		l2 := expandAroundCenter(s, i, i+1)
		len := max(l1, l2)
		if len > (end - start) {
			start = i - (len-1)/2
			end = i + len/2
		}
	}
	return s[start : end-1]
}

func expandAroundCenter(s string, left, right int) int {
	for left >= 0 && right < len(s) && s[left] == s[right] {
		left--
		right++
	}
	return right - left - 1
}
