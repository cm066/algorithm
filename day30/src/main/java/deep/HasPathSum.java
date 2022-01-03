package deep;


import javax.swing.tree.TreeNode;

/**
 * @author cm
 * @create 2021/12/28-11:28 下午
 */
public class HasPathSum {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    public static void main(String[] args) {

    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

}
