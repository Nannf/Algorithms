package com.nannf.exam.leetcode;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/4 20:31
 * @Description 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 输入：head = []
 * 输出：[]
 *
 * 输入：head = [1]
 * 输出：[1]
 */
public class Solution_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 这个是哨兵节点，也是最初的pre
        ListNode dummyNode = new ListNode();
        ListNode pre = dummyNode;
        pre.next = head;
        ListNode next = head.next;
        // 循环终止的条件是要么当前节点为空，要么next为空
        while (next != null) {
            ListNode tmp = next.next;
            head.next = tmp;
            pre.next = next;
            next.next = head;
            pre = head;
            head = tmp;
            // 这个是可能为空的
            if (head == null) {
                break;
            }
            next = head.next;
        }
        return dummyNode.next;
    }
}
