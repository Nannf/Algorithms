package thread;

/**
 * @author Nannf
 * @date 2021/6/21 17:47
 * @description 主要是验证wait结束之后是从方法的最开始开始执行，还是从wait之后开始执行。
 * 其实从方法的最开始执行比较扯
 * 因为我程序只是把自己挂起，不存在指令跳转命令。
 *
 * 我们要如何验证呢？
 *
 */
public class WaitTest {

    public static void main(String[] args) throws InterruptedException{
        WaitTest waitTest =  new WaitTest();
        new Thread(() -> testWait()).start();
        Thread.sleep(2000);
       new Thread(() ->tt() ).start();
    }


    public static void tt () {
        try {
            synchronized (WaitTest.class) {
                WaitTest.class.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testWait(){
        try {
            synchronized (WaitTest.class) {
                System.out.println(1);
                System.out.println(2);
                System.out.println(3);
                System.out.println(4);
                System.out.println("i am wait!");
                WaitTest.class.wait();
                System.out.println("i am notify");
                System.out.println(5);
                System.out.println(6);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
