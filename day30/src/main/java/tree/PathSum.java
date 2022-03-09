package tree;

import node.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cm
 * @create 2022/3/9-10:21 下午
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 */
public class PathSum {
    public static void main(String[] args) {

    }


    List<List<Integer>> ret1 = new LinkedList<List<Integer>>();
    Deque<Integer> path1 = new LinkedList<Integer>();

    public List<List<Integer>> pathSumByDFS(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret1;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null){
            return;
        }
        path1.offerLast(root.val);

        targetSum -= root.val;
        //找出所有 从根节点到叶子节点，叶子节点，就是左右节点为空
        if (root.left  == null  && targetSum == 0 && root.right == null){
            ret1.add(new LinkedList<Integer>(path1));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path1.pollLast();
    }



    /**
     * 可以采用递归加回溯的办法来解决  目前来说还是有问题的
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root,root.val,ret,path,targetSum);
        return ret;
    }
    public void helper(TreeNode root,int pathSum,List<List<Integer>> ret,List<Integer> path,int targetSum){
        if (root == null || pathSum == targetSum){
            if (pathSum == targetSum){
                ret.add(new ArrayList<>(path));
            }
        }
        path.add(root.left.val);
        helper(root.left,pathSum+root.left.val,ret,path,targetSum);
        path.remove(path.size()-1);
        path.add(root.right.val);
        helper(root.right,pathSum+root.right.val,ret,path,targetSum);
    }
}
