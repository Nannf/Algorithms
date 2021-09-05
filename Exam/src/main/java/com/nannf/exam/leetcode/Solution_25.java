package com.nannf.exam.leetcode;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/4 19:44
 * @Description k个一组反转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution_25 {
    // 老大难了
    // 老规矩，暴力解法，从0到k
    // 假设K=head的长度，那么问题退化成单链表反转
    // 我们可不可以从单链表反转的思路上获取灵感呢
    // 单链表反转的终止是结束，这个的终止是到k，如果不到k，就保持不变
    // 这个其实感觉可以使用递归做
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        // 先循环一次算出链表的长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        head = dummyNode.next;
        // 这个是连接k组的一个关键
        ListNode pre = dummyNode;
        ListNode next;
        // 一共需要进行 length / k 次处理
        for (int i = 0; i < length / k; i++) {
            // 对待每一组而言，我们要保留 每一组的head，这个是下一组的pre
            // 还要保留 tail.next 为了不中断
            // 之前的单链表反转时，我们是通过判断节点为null来终止循环的
            for (int j = 0; j < k - 1; j++) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }

        }


        return dummyNode.next;
    }
}
