package view.stack;

/**
 * @author Nannf
 * @version v1.0
 * @Description 数组实现的栈
 * 栈有
 * @date 2021/8/30 14:17
 */
public class ArrayStack {
    // 数据
    private Object[] data;
    // 容量
    private int size;

    // 已使用数据
    private int count;

    // 构造函数进行初始化
    public ArrayStack(int size) {
        data = new Object[size];
        this.size = size;
        this.count = 0;
    }

    // 入栈
    public boolean push(Object t) {
        if (count == size) {
            return false;
        }
        data[count] = t;
        count++;
        return true;
    }

    // 出栈
    public Object pop() {
        if (count == 0) {
            return null;
        }
        count--;
        return data[count];
    }


}
