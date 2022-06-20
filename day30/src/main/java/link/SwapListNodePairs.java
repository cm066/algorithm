package link;

import node.ListNode;

public class SwapListNodePairs {
    public static void main(String[] args) {

    }
    static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0,head);
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null){
            ListNode tmp = cur.next;
            ListNode tmp1 = cur.next.next.next;
            // 步骤一
            cur.next = cur.next.next;
            // 不能这样写，在第一步的时候就指针就改变了
            cur.next.next = cur.next;
            // 步骤二
            cur.next.next = tmp;
            // // 步骤三
            cur.next.next.next = tmp1;

            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}
