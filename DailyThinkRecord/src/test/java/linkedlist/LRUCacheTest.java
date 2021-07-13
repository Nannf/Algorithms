package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.addData(1);
        cache.addData(2);
        cache.addData(3);
        cache.addData(4);
        LinkedListUtil.printList(cache.getData());
    }

}