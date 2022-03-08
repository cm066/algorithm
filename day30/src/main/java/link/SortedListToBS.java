package link;

import node.ListNode;
import node.TreeNode;

/**
 * @author cm
 * @create 2022/3/8-10:45 下午
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedListToBS {

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }

    /**
     * 采用分治的方法来做，每次采用中位数来当作左右节点
     * @param left
     * @param right
     * @return
     */
    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right){
            return null;
        }
        ListNode median = getMedian(left, right);
        TreeNode root = new TreeNode(median.val);
        root.left =  buildTree(left,median);
        root.right = buildTree(median.next,right);
        return root;
    }

    /**
     * 采用快慢指针来获取每次的中位数节点
     * @param left
     * @param right
     * @return
     */
    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        //这里的right就相当于是最后一个节点
        while (fast != right && fast.next != right){
            fast = fast.next.next;
            slow =slow.next;
        }
        return slow;
    }
}
