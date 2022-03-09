package tree;

import node.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cm
 * @create 2022/3/9-9:47 下午
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 */
public class Flatten {
    public static void main(String[] args) {

    }
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root,list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.right = curr;
            prev.left = null;
        }
    }

    /**
     * 采用遍历的方式来进行前序遍历
     * @param root
     */
    public void preorderTraversal1(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null){
                list.add(node);
                stack.add(node);
                node = node.left;
            }
            //这里就不添加进list里面，因为前面就已经添加了
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        //这里就是从list集合里面取出数据，然后组装成链表
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.right = curr;
            prev.left = null;
        }
    }
    /**
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同 这里就直接利用容器把前序遍历的装起来 这里是采用递归的方法来进行前序遍历
     * @param root
     * @param list
     */
    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null){
            list.add(root);
            preorderTraversal(root.left,list);
            preorderTraversal(root.right,list);
        }
    }

}
