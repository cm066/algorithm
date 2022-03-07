package link;

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

    }

    /**
     * 把链表连城一个环，
     * 然后我们找到新链表的最后一个节点（即原链表的第 (n - 1) - (k mod n)个节点）
     * @param head
     * @param k
     * @return
     */
    public ListNode trotateRight(ListNode head, int k) {
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
