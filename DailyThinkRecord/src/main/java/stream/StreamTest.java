package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nannf
 * @date 2021/6/30 22:45
 * @description
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("nannf");
        list.add("we");
        list.add("qer");

        long length = list.stream().mapToLong(String::length).sum();
        System.out.println(length);
    }
}
