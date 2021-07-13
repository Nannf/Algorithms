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
        while (head.next != null) {
            System.out.print(head.e);
            System.out.print("->");
            head = head.next;
        }
        System.out.print(head.e);
        System.out.println();
    }
}
