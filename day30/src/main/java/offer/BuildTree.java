package offer;

import node.ListNode;
import node.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cm
 * @create 2022/3/27-9:44 下午
 * 重构二叉树
 */
public class BuildTree {
    private static Map<Integer, Integer> indexMap;
    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode node = buildTree(pre, in);
        printNode(node);
    }
    public static void printNode(TreeNode root){
        if (root != null) {
            System.out.print(root.val + "->");
            printNode(root.left);
            printNode(root.right);
        }
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper1(preorder,inorder,0, preorder.length-1,0, inorder.length-1);
//        return helper(preorder,inorder,0, preorder.length-1,0, inorder.length-1 );
    }
    //采用hash表来优化时间，但是空间复杂度提高了
    public static TreeNode helper1(int[] pre,int[] in, int left, int right,int left1,int right1){
        if (left >= pre.length || left1 >= in.length|| left > right || left1 > right){
            return null;
        }
        //这个相当于每次的头节点
        int value = pre[left];
        TreeNode node = new TreeNode(value);
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(value);
        int count = inorder_root - left1;
        node.left = helper(pre,in,left+1,left+count,left1,left1+count+1);
        node.right = helper(pre,in,left+count+1,right,left1+count+1,right1);
        return node;
    }

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
    /**
     *  preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 前序 [3],[9],[20,15,7]
     * 中序 [9],[3],[20,15,7]
     * @param pre
     * @param in
     * @param left 代表前序遍历的左边界
     * @param right 代表前序遍历的右边界
     * @param left1 代表中序遍历的左边界
     * @param right1 代表中序遍历的右边界
     * @return
     */
    public static TreeNode helper(int[] pre,int[] in, int left, int right,int left1,int right1){
        if (left >= pre.length || left1 >= in.length|| left > right || left1 > right){
            return null;
        }
        //这个相当于每次的头节点
        int value = pre[left];
        TreeNode node = new TreeNode(value);
        //每次的总的节点数
        int count = left1;
        //这里采用的是遍历的方式，时间复杂度比较高，这里可以采用hash表来降低每次获取中序遍历的下标
        while (in[count] != value){
            count++;
        }
        count -= left1;
        node.left = helper(pre,in,left+1,left+count,left1,left1+count+1);
        node.right = helper(pre,in,left+count+1,right,left1+count+1,right1);
        return node;
    }
}
