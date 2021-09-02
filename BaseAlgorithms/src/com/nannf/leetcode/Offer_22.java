package com.nannf.leetcode;

/**
 * @author Nannf
 * @version v1.0
 * @Description
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 * @date 2021/9/2 17:49
 */
public class Offer_22 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 第一遍循环找到链表长度，第二遍循环直接返回
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        for (int i = 0; i< length - k;i++) {
            head = head.next;
        }
        return head;
    }

}
