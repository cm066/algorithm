package deep;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cm
 * @create 2021/12/28-11:49 下午
 */
public class PathSum {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        if (root == null){
            return ans;
        }
        helper(root,targetSum,ans,combine);
        return ans;
    }

    private void helper(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> combine) {
        if (root.left == null && root.right == null){
            if (root.val == targetSum){
                ans.add(new ArrayList<>(root.val));
                return;
            }
        }
        if (root.val == targetSum){
            combine.add(root.val);
            ans.add(new ArrayList<>(combine));
        }
        if (root.left != null){
            helper(root.left,targetSum-root.val,ans,combine);
            combine.remove(combine.size()-1);
        }
        if (root.right != null){
            helper(root.right,targetSum-root.val,ans,combine);
            combine.remove(combine.size()-1);
        }
    }
}
