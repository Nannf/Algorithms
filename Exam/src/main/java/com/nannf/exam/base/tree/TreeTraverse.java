package com.nannf.exam.base.tree;

import com.nannf.exam.leetcode.TreeNode;

import java.util.List;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/5 15:55
 * @Description
 */
public class TreeTraverse {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        tree.left = t1;
        tree.right = t2;
        t1.left = t4;
        t1.right = t5;
        t2.left = t6;
        t2.right = t7;
        t4.left = t8;
    }

    public void preOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preOrder(root.left,ans);
        preOrder(root.right,ans);
    }

}
