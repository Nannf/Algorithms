package com.nannf.exam.leetcode;

/**
 * @author Nannf
 * @version v1.0
 * @Description  单链表反转
 * @date 2021/9/4 9:52
 */
public class Solution_206 {

    public ListNode reverseList(ListNode head) {
        // 1. 如果链表为空，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            // 保留下一个节点
            ListNode next = head.next;
            // 指针指向前一个
            head.next = pre;
            // 前一个变成head
            pre = head;
            // head 后移
            head = next;
        }
        // 当运行到这一步的时候，head已经是null了
        return pre;
    }
}
