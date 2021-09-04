package com.nannf.exam.leetcode;

/**
 * @author Nannf
 * @version v1.0
 * @Description 合并两个有序链表
 * @date 2021/9/4 18:22
 */
public class Solution_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode dummyNode = new ListNode();
        ListNode dummyHead = dummyNode;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                ListNode tmp = new ListNode(head1.val);
                dummyHead.next = tmp;
                dummyHead = tmp;
                head1 = head1.next;
            } else {
                ListNode tmp = new ListNode(head2.val);
                dummyHead.next = tmp;
                dummyHead = tmp;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            dummyHead.next = head1;
        }
        if (head2 != null) {
            dummyHead.next = head2;
        }
        return dummyNode.next;
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
            l1.next = mergeTwoLists_WithRecursion(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_WithRecursion(l2.next,l1);
            return l2;
        }
    }
}
