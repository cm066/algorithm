package main

func main() {

}

func isPalindrome(x int64) bool {

	if x < 0 || x%10 == 0 && x != 0 {
		return false
	}
	var reverseNum int64 = 0
	for x > reverseNum {
		reverseNum = reverseNum*10 + x%10
		x /= x
	}
	return x == reverseNum || x == reverseNum/10;
}