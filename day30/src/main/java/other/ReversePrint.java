package other;

import node.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cm
 * @create 2022/4/5-1:20 下午
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ReversePrint {
    public static void main(String[] args) {

    }

    /**
     * 反转打印链表；
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[]{};
        }
        //利用栈先进后出的特性来解决
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (head != null){
            stack.add(head.val);
            head = head.next;
            i++;
        }
        int[] ret = new int[i];
        i = 0;
        while (!stack.isEmpty()){
            ret[i++] = stack.pop();
        }
        return ret;
    }
    public int[] reversePrint1(ListNode head) {
        List<Integer> tmp = new ArrayList<>();
        recur(head,tmp);
        int[] ret = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            ret[i] = tmp.get(i);
        }
        return ret;
    }
    void recur(ListNode head,List<Integer> list) {
        if (head == null){
            return;
        }
        recur(head.next,list);
        list.add(head.val);
    }
}
