package jvm;

public class ExceptionTest {

    public static void main(String[] args) {

        try {

            System.out.println("before return");
            return;
        }catch (Exception e) {
            return;
        }finally {
            System.out.println("finally");
        }

    }
}
