package link;

import node.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author cm
 * @create 2022/3/12-10:18 上午
 *  面试题 02.07. 链表相交
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        System.out.println(null != null);
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode fastA = headA;
        ListNode fastB = headB;
        ListNode slowA = headA;
        ListNode slowB = headB;
        //现在两个两个链表的快指针一起跑，此时执行的次数就是最短的那条链表  min
        while (fastA != null && fastB != null){
            fastA = fastA.next;
            fastB = fastB.next;
        }
        if (fastA == null){
            //这里说明链表A是短的那条链表
            while (fastB != null){
                //此时快慢指针一起走
                fastB = fastB.next;
                slowB = slowB.next;
            }
        }else if (fastB == null){
            //说明链表B是短的链表
            while (fastA != null){
                fastA = fastA.next;
                slowA = slowA.next;
            }
        }
        //然后让两个链表的慢指针一起走
        while (slowA != slowB){
            //这里其实就防止了两个链表没有交集的时候出现死循环
            slowA = slowA.next;
            slowB = slowB.next;
        }
        return slowA;
    }
    /**
     * 这个超出了时间范围
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode A = headA,B = headB;
        while (A != B){
            A = A != null? headA.next : headB;
            B = B != null ? headB.next : headA;
        }
        return A;
    }
    /**
     * 保证 整个链式结构中不存在环 这句话是重点，因为有环4和没环是有区别的
     * 第一种采用hash表来存储
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
