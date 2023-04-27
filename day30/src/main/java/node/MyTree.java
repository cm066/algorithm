package node;

import java.util.Deque;
import java.util.LinkedList;

public class MyTree {

    public static void main(String[] args) {
//        手写代码，实现：
//        1、指定高度，生成满二叉树；
//        2、将二叉树转换成链表；
//        3、将生成一个按照先序遍历时输出1、2、3、4、5、6、7... 15 这样的树，指定树的层数
        TreeNode treeNode = buildTree(4);

    }

    public static TreeNode buildTreeByBack(int h, int index) {

        TreeNode root = new TreeNode();
        return null;

    }

    public static TreeNode buildTree(int h) {
        Deque<TreeNode> deque = new LinkedList<>();
        int i = 1;
        int index = 1;
        TreeNode root = new TreeNode(1);
        deque.add(root);
        while (index < h) {
            int size = deque.size();
            for (int j = 0; j < size; j++) {
                TreeNode pop = deque.pop();
                pop.left = new TreeNode(++i);
                pop.right = new TreeNode(++i);
                deque.add(pop.left);
                deque.add(pop.right);
            }
            index++;
        }
        return root;
    }

    public static ListNode treeToLink(TreeNode root) {
        ListNode ret = new ListNode(0);
        ListNode cur = ret;

        return ret.next;
    }
}
