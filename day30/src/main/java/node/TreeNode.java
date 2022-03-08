package node;

/**
 * @author cm
 * @create 2022/3/8-10:43 下午
 */
/**
 * Definition for a binary tree node.
 *  */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public  TreeNode() {}
     public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
