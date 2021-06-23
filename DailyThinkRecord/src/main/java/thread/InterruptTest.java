package thread;

/**
 * @author Nannf
 * @date 2021/6/23 15:56
 * @description
 */
public class InterruptTest {

    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(() -> test());
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }

    public static void test() {
        Thread th = Thread.currentThread();
        while (true) {
            if (th.isInterrupted()) {
                System.out.println(111);
                break;
            }
            // 省略业务代码无数
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
