package view.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nannf
 * @version v1.0
 * @Description  hashMap 在扩容时做了什么
 * @date 2021/8/31 16:17
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<20;i++) {
            map.put(i,i);
        }
    }
}
