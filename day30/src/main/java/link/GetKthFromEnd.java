package link;

import node.ListNode;

/**
 * @author cm
 * @create 2022/1/5-10:54 下午
 * 链表的倒数第k个节点
 */
public class GetKthFromEnd {
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
        ListNode kth = getKthFromEnd(n1, 2);
        RemoveNthFromEnd.printNode(kth);
    }

    /**
     * 采用快慢指针，也可以采用遍历的方式遍历出有多少个节点
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
