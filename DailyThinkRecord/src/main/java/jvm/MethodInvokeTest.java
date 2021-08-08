package jvm;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/8 20:40
 */
public class MethodInvokeTest {


    public void test1(int i ) {
        System.out.println("int");
    }

    public void test1(Integer i) {
        System.out.println("integer");
    }

    public static void main(String[] args) {
        new MethodInvokeTest().test1(new Integer(1));
    }
}
