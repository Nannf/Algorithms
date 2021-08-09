package jvm;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/9 21:38
 */
public class OverrideTest {


    class Father<T> {
        public void get(T obj) {
            System.out.println("father");
        }
    }

    class Son extends Father<Integer> {

        @Override
        public void get(Integer integer) {
            System.out.println("integer");
        }
    }
}
