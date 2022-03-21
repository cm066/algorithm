package back;

import node.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cm
 * @create 2022/3/16-11:16 下午
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 */
public class GenerateTrees {
    public static void main(String[] args) {
        int i = numTrees(3);
        System.out.println(i);
    }

    public static int numTrees(int n) {

        //如果只有0，或者1个节点，则可能的子树情况为1种
        if (n == 0 || n == 1){
            return 1;
        }

        int count = 0;
        System.out.println(count);
        for (int i = 1; i <= n; i++) {

            //当用i这个节点当做根节点时

            //左边有多少种子树
            int leftNum = numTrees(i-1);

            //右边有多少种子树
            int rightNum = numTrees(n-i);

            //乘起来就是当前节点的子树个数
            count+=leftNum*rightNum;
        }

        return count;

        //此方法重复计算太多，见解法二
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end){
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i+1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
