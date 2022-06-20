package link;

import node.ListNode;

public class ReverseListNode {
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
        printNode(n1);
        ListNode reverse = reverse1(n1);
//        ListNode reverse = reverseList1(n1);
        printNode(reverse);
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
    //从前往后翻转  1 ---> 2 ---> 3 ---> 4
    /*
    1 <--- 2  3--->4
    1 <--- 2 <--- 3 4
    1 <--- 2 <--- 3 <--- 4
     */
    public static ListNode reverse(ListNode pre, ListNode cur){
        if (cur == null){
            return pre;
        }
        ListNode tmp = cur.next;
        cur.next = pre;
        return reverse(cur,tmp);
    }
    // 从后往前翻转
    public static ListNode reverse1(ListNode head){
        // 边缘条件判断
        if(head == null) return null;
        if (head.next == null) return head;

        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverse1(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        //这里是返回的last，在递归结束的时候就指向了最后一个节点
        return last;
    }
    public static ListNode reverseList1(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
