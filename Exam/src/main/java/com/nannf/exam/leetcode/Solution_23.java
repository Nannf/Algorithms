package com.nannf.exam.leetcode;

/**
 * @author Nannf
 * @version v1.0
 * @Description 合并k个有序链表
 * @date 2021/9/4 18:21
 */
public class Solution_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }
        for (int i = 1; i < lists.length; i++) {
            lists[0] = mergeTwoLists_WithRecursion(lists[0],lists[i]);
        }
        return lists[0];
    }

    // 递归版本,递归函数的含义就是合并两个有序链表
    public ListNode mergeTwoLists_WithRecursion(ListNode l1, ListNode l2) {
        // 递归终止条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 罗列所有的情况
        // 我们返回的结果保存在哪呢
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_WithRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_WithRecursion(l2.next, l1);
            return l2;
        }
    }
}
