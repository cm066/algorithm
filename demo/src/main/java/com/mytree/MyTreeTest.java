package com.mytree;

import java.util.LinkedList;

public class MyTreeTest {

    public static void main(String[] args) {

//        刚才被一个制药公司的二面淘汰了。
//        手写代码，实现：
//        1、指定高度，生成满二叉树；
//        2、将二叉树转换成链表；
//        3、将生成一个按照先序遍历时输出1、2、3、4、5、6、7... 15 这样的树，指定树的层数

    }


}

class MyTree<T> {

    //TreeNode是内部类：二叉树的存储结构
    private class TreeNode {
        private T data;//数据域
        private TreeNode left;//左孩子指针
        private TreeNode right;//右孩子指针

        public TreeNode(T data) {
            this.data = data;
        }
    }

    private TreeNode root;//根节点
    private LinkedList<TreeNode> dequee = new LinkedList<>();//队列

    public void printNode() {
        TreeNode p = this.root;
        print(p);
    }

    public void add(T data) {
        if (this.root == null) {
            root = new TreeNode(data);
            dequee.add(this.root);
        } else {
            if (!dequee.isEmpty()) {
                TreeNode node = dequee.getFirst();
                if (node.left == null) {
                    node.left = new TreeNode(data);
                    dequee.addLast(node.left);
                } else {
                    node.right = new TreeNode(data);
                    dequee.addLast(node.right);
                    dequee.pollFirst();
                }
            }
        }
    }

    //先序遍历输出
    private void print(TreeNode p) {
        if (p != null) {
            System.out.println(p.data);
            print(p.left);
            print(p.right);
        }
    }

}