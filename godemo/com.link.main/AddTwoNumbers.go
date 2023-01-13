package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {

}
func addTwoNumbers(l1, l2 *ListNode) (head *ListNode) {
	var tail *ListNode
	var cur int
	for l1 != nil || l2 != nil {
		n1, n2 := 0, 0
		if l1 != nil {
			n1 = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			n2 = l2.Val
			l2 = l2.Next
		}
		sum := n1 + n2 + cur
		sum, cur = sum%10, sum/10
		if head == nil {
			head = &ListNode{Val: sum}
			tail = head
		} else {
			tail.Next = &ListNode{Val: sum}
			tail = tail.Next
		}
		if cur != 0 {
			tail.Next = &ListNode{Val: cur}
		}
	}
	return
}
