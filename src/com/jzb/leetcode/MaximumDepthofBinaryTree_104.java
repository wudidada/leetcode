package com.jzb.leetcode;

public class MaximumDepthofBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String[] args) {
        MaximumDepthofBinaryTree_104 test = new MaximumDepthofBinaryTree_104();
        TreeNode t = new TreeNode(3,9,20,null,null,15,7);
        System.out.println(test.maxDepth(t));
    }
}
