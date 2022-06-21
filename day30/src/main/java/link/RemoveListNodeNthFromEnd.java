package link;

import node.ListNode;

public class RemoveListNodeNthFromEnd {
    public static void main(String[] args) {

    }
    //快慢指针来解决问题
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0,head);
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while (n-- > 0) {
            fast = fast.next;
        }
        ListNode prev = null;
        while (fast != null){
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        // 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点 slow慢指针指向的是要删除的节点
        prev.next = slow.next;
        // 释放 待删除节点slow 的next指针, 这句删掉也能AC
        slow.next = null;
        return dummyHead.next;
    }
}
