package link;

import node.ListNode;

/**
 * @author cm
 * @create 2022/1/4-8:32 下午
 */
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
        ListNode listNode = removeNthFromEnd(n1, 2);
        printNode(listNode);
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
    /**
     *  可以先遍历一遍，看也多少个节点，然后在遍历一次,还可以用栈的思想来解决
     *  也可以采用快慢指针的方法来遍历
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
