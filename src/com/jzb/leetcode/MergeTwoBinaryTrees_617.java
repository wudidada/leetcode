package com.jzb.leetcode;

public class MergeTwoBinaryTrees_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        int value = 0;
        if (t1 != null) {
            value += t1.val;
        }

        if (t2 != null) {
            value += t2.val;
        }

        TreeNode tree = new TreeNode(value);
        tree.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        tree.right = mergeTrees(t1 == null ? null : t1.right, t1 == null ? null : t2.right);

        return tree;
    }
}

