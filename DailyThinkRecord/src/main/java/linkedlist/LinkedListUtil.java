package linkedlist;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/7/13 21:52
 */
public class LinkedListUtil {

    public static <E> void printList(SingleLinkedList<E> SingleLinkedList) {
        SingleLinkedList<E> head = SingleLinkedList;
        while (head != null) {
            System.out.println(head.e);
            head = head.next;
        }
    }
}
