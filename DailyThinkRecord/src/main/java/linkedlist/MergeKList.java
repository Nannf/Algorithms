package linkedlist;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 输入：lists = []
 * 输出：[]
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 *
 * @date 2021/7/15 9:04
 */
public class MergeKList {

    // 我们可以两两合并，
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return new ListNode();
        }
        if (lists.length == 1) {
            return lists[0];
        }
        for (int i = 1; i< lists.length ;i++) {
            ListNode newNode = mergeTwoLists(lists[0],lists[i]);
            lists[0] = newNode;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode dummyHead = dummyNode;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                dummyNode.next = new ListNode(head1.val);

                head1 =head1.next;
            } else {
                dummyNode.next = new ListNode(head2.val);
                head2 =head2.next;
            }
            dummyNode = dummyNode.next;
        }
        if (head1 != null) {
            dummyNode.next = head1;
        } else {
            dummyNode.next = head2;
        }
        return dummyHead.next;
    }
}
