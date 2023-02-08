package com.link;

import java.util.*;

public class MergeKLists {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = new ListNode();
        ListNode cur = ret;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        // 利用优先队列来解决问题 重点就是在这里
        PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
        for (ListNode list : lists) {
            queue.add(list);
        }
        while (!queue.isEmpty()) {
            ListNode listNode = queue.poll();
            cur.next = listNode;
            cur = cur.next;
            if (listNode.next != null) {
                queue.add(listNode.next);
            }
        }
        return ret.next;
    }
}
