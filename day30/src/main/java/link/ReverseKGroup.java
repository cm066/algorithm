package link;

import node.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author cm
 * @create 2022/1/6-9:00 下午
 * 25. K 个一组翻转链表
 */
public class ReverseKGroup {
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
        ListNode listNode = reverseKGroup1(n1, 3);
        RemoveNthFromEnd.printNode(listNode);
    }

    public static ListNode reverseKGroup1(ListNode head, int k) {
       ListNode hair = new ListNode(0);
       hair.next = head;
       ListNode pre = hair;
       while (head != null){
           ListNode tail = pre;
           for (int i = 0; i < k; i++) {
               tail = tail.next;
               if (tail ==null){
                   return hair.next;
               }
           }
           ListNode next = tail.next;
           ListNode[] reverse = myReverse(head, tail);
           head = reverse[0];
           tail = reverse[1];
           // 把子链表重新接回原链表
           pre.next = head;
           tail.next = next;
           pre = tail;
           head = tail.next;
       }
       return hair.next;
    }

    public static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
    /**
     * 采用双端队列
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode newHead =new ListNode(0);
        boolean flag = false;
        ListNode tmp1 = null;
        int index = 0;
        while (head != null){
            index++;
            tmp1 = head.next;
            head.next = null;
            deque.add(head);
            if (index == k){
                if (!flag){
                    ListNode node = deque.removeLast();
                    newHead.next = node;
                    deque.addFirst(node);
                    flag = true;
                }
                ListNode tmpHead = deque.removeFirst();
                while (deque.size() != 0){
                    ListNode node = deque.removeLast();
                    tmpHead.next = node;
                    tmpHead = tmpHead.next;
                }
                deque.add(tmpHead);
                index = 0;
            }
            head = tmp1;
        }
        if (index != 0){
            ListNode  tmpHead = deque.removeFirst();
            while (deque.size() != 0){
                ListNode node = deque.removeFirst();
                tmpHead.next = node;
                tmpHead = tmpHead.next;
            }
        }
        return newHead.next;
    }
}
