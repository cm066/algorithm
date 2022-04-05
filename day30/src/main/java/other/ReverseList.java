package other;

import node.ListNode;

import java.util.List;

/**
 * @author cm
 * @create 2022/4/5-2:06 下午
 * 反转链表
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    /**
     * 采用双指针的思路来解决
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode cur = head,pre = null;
        while (cur != null){
            //这个是保存下面的节点，防止丢失
            ListNode tmp = cur.next;
            //这一步就是双指针反转链表的关键，
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    public ListNode reverseList1(ListNode head) {
        // 调用递归并返回
        return recur(head, null);
    }
    private ListNode recur(ListNode cur, ListNode pre) {

        if (cur == null) {
            // 终止条件
            return pre;
        }
        // 递归后继节点
        ListNode res = recur(cur.next, cur);
        // 修改节点引用指向
        cur.next = pre;
        // 返回反转链表的头节点
        return res;
    }
    /**
     * 使用递归的方式来实现
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        //因为这里的下一个节点才是最后一个节点
        head.next.next = head;
        //这一步是为了反正形成环
        head.next = null;
        return newHead;
    }

}
