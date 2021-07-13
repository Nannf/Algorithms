package linkedlist;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description 单链表
 * @date 2021/7/13 21:24
 * 有一个数据节点，有一个next指针指向后面的节点
 */
public class SingleLinkedList<E> {
    E e;
    SingleLinkedList<E> next;

    public SingleLinkedList(E e, SingleLinkedList<E> next) {
        this.e = e;
        this.next = next;
    }
}
