package link;

import node.ListNode;

/**
 * @author cm
 * @create 2022/3/7-10:32 下午
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 这道题和删除数组重复的数字是一样的
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        printNode(n1);
        System.out.println("*********");
        ListNode node = deleteDuplicates(n1);
        printNode(node);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode cur = head;
        while (cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
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
}
