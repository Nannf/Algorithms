package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.addData(1);
        cache.print();
        cache.addData(2);
        cache.print();
        cache.addData(3);
        cache.print();
        cache.addData(4);
        cache.print();
        cache.addData(1);
        cache.print();
        cache.addData(5);
        cache.print();
    }

}