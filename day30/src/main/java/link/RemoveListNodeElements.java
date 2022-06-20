package link;

import node.ListNode;

public class RemoveListNodeElements {
    public static void main(String[] args) {

    }
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        // 1 ---> 4 ---> 2 ---> 4
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                //
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            //不写这个就是死循环，节点不能往下移动
            cur = cur.next;
        }
        return dummy.next;
    }
}
