package linkedlist;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description 单链表反转
 * @date 2021/7/15 8:36
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        // 别返回cur，cur此时已经为0了
        return prev;
    }
}
