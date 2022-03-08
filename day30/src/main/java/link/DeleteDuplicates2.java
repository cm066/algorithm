package link;

import node.ListNode;

/**
 * @author cm
 * @create 2022/3/8-9:39 下午
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 */
public class DeleteDuplicates2 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        printNode(n1);
        System.out.println("*******");
        ListNode node = deleteDuplicates(n1);
        printNode(node);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode ret = new ListNode(0,head);
        ListNode cur = ret;
        while (cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;;
                //这一步就是依次往下找到于当前x值不相等的节点
                while (cur.next != null &&  cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                //这里说明相邻两个节点的值不相等，节点就要往下移动
                cur = cur.next;
            }
        }
        return ret.next;
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
