package linkedlist;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description 双链表，一个指向自己前驱节点的prev节点，和指向自己后继的next节点
 * @date 2021/7/13 21:24
 */
public class DoubleLinkedList<E> {
    E e;

    DoubleLinkedList<E> head;

    DoubleLinkedList<E> tail;

    DoubleLinkedList<E> prev;

    DoubleLinkedList<E> next;

    public DoubleLinkedList(E e, DoubleLinkedList<E> prev, DoubleLinkedList<E> next) {
        this.e = e;
        this.prev = prev;
        this.next = next;
    }
}
