package reference;

import java.lang.ref.WeakReference;

/**
 * @author Nannf
 * @date 2021/7/5 11:13
 * @description 当一个对象是WeakReference, 但是这个对象被强引用所引用时，是否会被回收
 */
public class WeakReferenceTest {
    private Entry[] table;

    static class Entry extends WeakReference<Nannf> {
        Nannf value;

        Entry(Nannf v) {
            super(v);
        }
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Apple： " + value + " finalize。");
        }
    }

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

    public WeakReferenceTest(int size) {
        table = new Entry[size];
        for (int i = 0; i < size; i++) {
            Entry entry = new Entry(new Nannf(i));
            table[i] = entry;
        }
    }

    public static void main(String[] args) {
        WeakReferenceTest test = new WeakReferenceTest(5);
        new Nannf(9527);
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
