package likou;

import node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cm
 * @create 2022/3/22-10:54 下午
 * 617. 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。

 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 */
public class MergeTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode right5 = new TreeNode(4);
        right.left = right5;
        root.left = left;
        root.right = right;
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode right15 = new TreeNode(4);
        left.right = right15;
        root1.left = left1;
        root1.right = right1;
        mergeTrees(root,root1);
    }
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val+ t2.val);
        merged.left = mergeTrees(t1.left,t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}
