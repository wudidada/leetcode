package com.jzb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(List<Integer> list) {
        if (list.size() <= 0 || list.get(0) == null) {
            return;
        }

        list.add(0, 0);
        val = list.get(1);
        left = create(list, 2);
        right = create(list, 3);
    }

    TreeNode(Integer... l) {
        this(new ArrayList<Integer>(Arrays.asList(l)));
    }

    private TreeNode create(List<Integer> list, int index) {
        if (index >= list.size() || list.get(index) == null) {
            return null;
        }

        TreeNode tree = new TreeNode(list.get(index));
        tree.left = create(list, index * 2);
        tree.right = create(list, index * 2 + 1);

        return tree;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3,9,20,null,null,15,7);

        System.out.println(tree.left.val);
        System.out.println(tree.right.left.val);
    }
}
