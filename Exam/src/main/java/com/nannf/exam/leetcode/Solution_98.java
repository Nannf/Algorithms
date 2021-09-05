package com.nannf.exam.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/5 15:44
 * @Description 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Solution_98 {

    public boolean isValidBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        for (int i = 1; i< ans.size();i++) {
            if (ans.get(i) <= ans.get(i -1)) {
                return false;
            }
        }
        return true;
    }


    public void inOrder(TreeNode root, List<Integer> ans){
        if (root == null) {
            return;
        }
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
}
