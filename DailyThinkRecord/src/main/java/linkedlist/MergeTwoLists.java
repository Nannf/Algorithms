package linkedlist;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/7/15 14:53
 * 合并两个有序链表，
 * 拿两个指针逐个比即可
 */
public class MergeTwoLists {
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
