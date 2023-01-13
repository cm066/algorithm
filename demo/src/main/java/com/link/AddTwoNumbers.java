package com.link;

public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(25 % 10);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode();
//        ListNode cur = head;
        ListNode head = null ,tail = null;
        // 用于两个节点的进位
        int k = 0;
        while (l1 != null || l2 != null) {
            int a1 = l1 != null ? l1.val : 0;
            int a2 = l2 != null ? l2.val : 0;
            int sum = a1 + a2 + k;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

//            cur.next = new ListNode(result % 10);
//            cur = cur.next;
            k = sum / 10;
            if (l1.next != null){
                l1 = l1.next;
            }
            if (l2.next != null){
                l2 = l2.next;
            }

        }
        // 这里是处理最后进位的
        if (k != 0){
            tail.next = new ListNode(k);
        }

        return head.next;
    }
}
