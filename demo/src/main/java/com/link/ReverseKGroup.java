package com.link;

import java.util.Stack;

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode head = ListNode.getHead();
        ListNode listNode = reverseKGroup(head, 3);
        ListNode.printNode(listNode);

//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        n4.next = n5;
//        n3.next = n4;
//        n2.next = n3;
//        n1.next = n2;
//        ListNode listNode1 = reverseKGroup(n1, 2);
//        ListNode.printNode(listNode1);
    }


    public static ListNode reverseKGroup1(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
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

    // 先利用栈的想法来解决一下思路问题
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode ret = new ListNode();
        ListNode cur = ret;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            ListNode tmp = head;
            int i = k;
            while (head != null && i > 0) {
                stack.add(head);
                head = head.next;
                i--;
            }

            if (stack.size() == k) {
                ListNode pop = stack.pop();
                head = pop.next;
                pop.next = null;
                cur.next = pop;
                cur = cur.next;
                while (!stack.isEmpty()) {
                    ListNode pop1 = stack.pop();
                    pop1.next = null;
                    cur.next = pop1;
                    cur = cur.next;
                }
            } else {
                cur.next = tmp;
            }
        }
        return ret.next;
    }
}
