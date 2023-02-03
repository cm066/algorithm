package com.link;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        ListNode listNode = removeNthFromEnd(n1, 4);
        printNode(listNode);
    }

    // 遍历1次,快慢指针，主要还是找到要删除节点的前一个节点即可
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        // 用一个头节点来找到删除节点的前一个节点，这样方便删除
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    public static void printNode(ListNode head){
        if (head == null){
            return;
        }
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    /// 输入：head = [1,2,3,4,5], n = 2
    //输出：[1,2,3,5]
    // 这是遍历了两次
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = new ListNode(0,head);
        int count = 0;
        ListNode cur = head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        cur = ret.next;
        for (int i = 1; i < count - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return ret.next;
    }
}
