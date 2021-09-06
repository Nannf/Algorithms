package com.nannf.exam.leetcode;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/5 16:13
 * @Description
 */
public class Solution_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

}
