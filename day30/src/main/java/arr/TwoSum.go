package arr

import "fmt"

func main() {
	ss := []int{2, 7, 11, 15}
	sum := TwoSum(ss, 9)
	fmt.Println(sum)
}
func TwoSum(nums []int, target int) []int {
	map1 := make(map[int]int)
	for i, v := range nums {
		a := target - v
		_, ok := map1[a]
		if ok {
			ret := []int{map1[a], i}
			return ret
		} else {
			map1[a] = i
		}
	}
	return nil
}
