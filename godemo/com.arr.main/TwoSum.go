package main

func main() {

	nums := []int{2, 7, 11, 15}
	sum := twoSum(nums, 9)
	println(sum)
}
func twoSum(nums []int, target int) []int {
	maps := map[int]int{}
	for i, num := range nums {
		if value, ok := maps[target-num]; ok {
			return []int{value, i}
		} else {
			maps[num] = i
		}
	}
	return nil
}
