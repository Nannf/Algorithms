package analyze;

/**
 * @author Nannf
 * @version v1.0
 * @Description 冒泡排序
 * @date 2021/8/25 22:19
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 1, 2, 3};
        process(a, a.length);
        for (int i : a) {
            System.out.println(i);
        }

    }

    private static void process(int[] a, int length) {
        // 冒泡就是两两比较，每次都把最大的冒到数组的最后
        // 其实只要冒n-1次就可以了，每次都是从头开始比较，比较的结束是随着比较的进行而逐步递减的

        boolean flag = false;
        // 需要比较n-1次，当我们发现针对某一个序列，运行结束之后没有需要交换的数时，表示已经有序
        for (int i = 0; i < length - 1; i++) {
            // 每次都是从0开始比较,每次比较的次数这个可以通过枚举来找到示例
            // length = 6, 第一次 i = 0， 需要比较5次
            // 第二次 i = 1,需要比较4次
            // j = 6 - (i+1)
            for (int j = 0; j < length - (i + 1); j++) {
                if (a[j] > a[j + 1]) {
                    // swap
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    // 表示还有交换
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }
}
