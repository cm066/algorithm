package link;

import node.ListNode;

import javax.swing.text.html.HTMLDocument;

/**
 * @author cm
 * @create 2022/1/3-8:45 下午
 */
public class ReverseList {
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
        ListNode reverseList = reverseList(n1);
        printNode(reverseList);
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
     * 使用递归的方式来实现
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        //因为这里的下一个节点才是最后一个节点
        head.next.next = head;
        //这一步是为了反正形成环
        head.next = null;
        return newHead;
    }
    /**
     *  使用遍历的方式来实现
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode headNode =new ListNode();
        while (head != null){
            ListNode tmp = head.next;
            head.next = null;
            ListNode tmp1 = headNode.next;
            head.next = tmp1;
            headNode.next = head;
            head = tmp;
        }
        return headNode.next;
    }
}
