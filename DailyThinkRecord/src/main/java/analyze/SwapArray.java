package analyze;

/**
 * @author Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/17 18:41
 * <p>
 * 给定数组a,给定一个值i，把i之后（不包括i）和i之前的元素替换了，但是保证每半边的元素相对顺序不变
 * 例如：
 * 现有数组a[1,2,3,4,5,6,7],和i=3
 * 输出
 * 5，6，7，1，2，3，4
 */
public class SwapArray {

    // 这个方法是冒泡
    public static int[] swap2(int[] a, int len, int i) {
        if (len <= i) {
            throw new IllegalArgumentException("非法的i");
        }
        // 每个都冒泡冒上去
        for (int j = i + 1; j < len; j++) {
            // 这个记录的是每次要冒泡的下标，会随着冒泡的进行逐渐减少
            int t = j;
            // 这个是每次冒泡要交换的下标，每个都需要交换i+1次
            for (int k = j - 1; k > j - 1 - (i + 1); k--) {
                int temp = a[t];
                a[t] = a[k];
                a[k] = temp;
                t--;
            }
        }
        return a;
    }


    // 这种方法是用一个临时的跟a大小一样的数组
    public static int[] swap1(int[] a, int len, int i) {
        if (len <= i) {
            throw new IllegalArgumentException("非法的i");
        }
        int[] b = new int[len];
        int index = 0;
        for (int j = i + 1; j < len; j++) {
            b[index++] = a[j];
        }

        for (int j = 0; j <= i; j++) {
            b[index++] = a[j];
        }

        return b;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        for (int i : swap2(a, a.length, 3)) {
            System.out.println(i);
        }
    }

}
