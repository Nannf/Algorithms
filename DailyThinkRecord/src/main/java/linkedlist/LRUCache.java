package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/7/13 21:22
 * 最近最久未使用淘汰算法。基于单链表实现
 * 有如下前提：
 * - 我们的内存空间有限，体现在代码中就是长度限制
 * - 我们如何体现最近最近未使用呢？
 * - 如果我们新插入一个节点，这个节点的值我们之前刚访问过，那么需要找到这个节点，删除它，然后插入到链表的头部
 * - 如果我们没有访问过，我们要判断链表是否已经满了，如果没满，直接插入头部
 * - 如果满了，剔除队尾的元素
 * -
 */
public class LRUCache {
    // 内存大小
    private int size;

    private int count;

    private SingleLinkedList<Integer> data;

    private Set<Integer> existsData;

    public LRUCache(int size) {
        this.size = size;
        this.data = new SingleLinkedList<>(null, null);
        count = 0;
        existsData = new HashSet<>(size);
    }


    public void addData(int value) {
        if (existsData.contains(value)) {
            // 我们找到这个节点，删掉它，然后插入到链表的头
            deleteNodeByValue(value);
            addHead(value);
        } else {
            existsData.add(value);
            // 链表中存储的数量要加一
            count++;
            // 如果超过了设置的阈值
            if (count > size) {
                // 删除队尾的节点
                deleteTail();
                count--;
            }
            addHead(value);
        }

    }

    private void deleteTail() {
        SingleLinkedList<Integer> head = data;
        SingleLinkedList<Integer> prev = data;
        while (head.next != null) {
            prev = head;
            head = head.next;
        }
        prev.next = null;
    }

    private void addHead(int value) {
        SingleLinkedList<Integer> node = new SingleLinkedList<>(value, null);
        node.next = data.next;
        data.next = node;
    }

    private void deleteNodeByValue(int value) {
        SingleLinkedList<Integer> head = data;
        SingleLinkedList<Integer> prev = data;
        while (head != null) {
            if (head.e == value) {
                prev.next = head.next;
            }
            prev = head;
            head = head.next;
        }
    }


    public SingleLinkedList<Integer> getData() {
        return data;
    }
}
