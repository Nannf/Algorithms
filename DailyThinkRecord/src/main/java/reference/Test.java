package reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/7/31 8:33
 * 这个测试的目的，就是我们有一个强引用对象，这个对象赋值给弱引用，当发生gc的时候，这个对象会被回收吗
 *
 */
public class Test {
    static class Nannf  {
        Integer value;

        Nannf(Integer v) {
            value = v;
        }
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Nannf： " + value + " finalize。");
        }
    }

    public static void main(String[] args) {
        Nannf nannf  = new Nannf(9527);
        TestWeakReference<Nannf> weakReference = new TestWeakReference<>( nannf);
        nannf = null;

        System.gc();

        try {
            //休眠一下，在运行的时候加上虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(1);
    }
}
