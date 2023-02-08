package com.link;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
//        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        ListNode listNode = swapPairs(n1);
        ListNode.printNode(listNode);
    }

    // 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,3,4]
    //输出：[2,1,4,3]
    public static ListNode swapPairs(ListNode head) {
        ListNode ret = new ListNode();
        ListNode retCur = ret;
        while (head != null && head.next != null) {
            ListNode tmp = head.next.next;
            ListNode next = head.next;
            head.next = null;
            next.next = head;
            retCur.next = next;
            retCur = head;
            head = tmp;
        }
        if (head != null) {
            retCur.next = head;
        }
        return ret.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(head.next);
        newHead.next = head;
        return newHead;
    }


    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
