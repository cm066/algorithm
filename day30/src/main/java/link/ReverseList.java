package link;

import node.ListNode;


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
        ListNode reverse = reverse(n1, 3, 4);
        printNode(reverse);
//        ListNode reverseList = reverseList(n1);
//        printNode(reverseList);
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

    /**
     * 局部链表反转，给定一个范围，将这个范围内的链表反转
     * @param head
     * @param start
     * @param end
     * @return
     */
    public static ListNode reverse(ListNode head,int start,int end){
        if (head == null){
            return head;
        }
        ListNode cur = head;
        int a = 1;
//        ListNode newHead = null;
        ListNode tmp1 = null;
        ListNode tmp2 = null;
        while (cur != null){
            if (a == start){
//                newHead = cur;
//                ListNode tmp = newHead;
//                while (tmp != null){
//                    if (a == end){
//                        tmp2 = tmp.next;
//                        tmp.next = null;
//                        break;
//                    }
//                    a++;
//                    tmp = tmp.next;
//                }
                break;
            }
            a++;
            //这个的作用是记录反转第一个节点的前一个节点，等一下之间和反转好的链表的头节点连接起来即可了
            tmp1 = cur;
            cur = cur.next;
        }
        ListNode tmp = cur;
        while (tmp != null){
            if (a == end){
                //记录要反转后链表的最后一个节点的下一个节点
                tmp2 = tmp.next;
                tmp.next = null;
                break;
            }
            a++;
            tmp = tmp.next;
        }
        ListNode rever = rever(cur);
        //这个是反转后链表的最后一个节点，
        tmp = tmp1.next;
        tmp1.next = rever;
        //这个就是将反转后链表的尾节点连接起之前的节点
        tmp.next = tmp2;
        return head;
    }
    public static ListNode rever(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = rever(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
