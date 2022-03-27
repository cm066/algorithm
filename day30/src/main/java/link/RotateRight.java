package link;

import heap.Heap;
import node.ListNode;

/**
 * @author cm
 * @create 2022/3/7-9:23 下午
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 61. 旋转链表
 */
public class RotateRight {
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
        ListNode listNode = trotateRight(n1, 2);
        printNode(listNode);
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
     * 把链表连城一个环，
     * 然后我们找到新链表的最后一个节点（即原链表的第 (n - 1) - (k mod n)个节点）
     * @param head
     * @param k
     * @return
     */
    public static ListNode trotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }
        int n =1;
        ListNode iter = head;
        while (iter.next != null){
            n++;
            iter = iter.next;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        //这里就是将链表构成环
        iter.next = head;
        while (add-- > 0){
            iter= iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
