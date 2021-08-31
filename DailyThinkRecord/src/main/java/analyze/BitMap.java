package analyze;

/**
 * @author Nannf
 * @version v1.0
 * @Description 位图
 * @date 2021/8/31 22:14
 */
public class BitMap {
    // 我们用char来表示一位，一个char是2字节，可以表示16位
    private char[] bytes;
    // 二进制位，这个表示的数据的边界，比如我们的数字范围是1亿，那么我们使用一亿个字节来表示即可
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits / 16 + 1];
    }

    public void set(int k) {
        // 超过了边界
        if (k > nbits) {
            return;
        }
        // 算出在哪一个数组元素里
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        // 1<< bitIndex 把1左移这个
        // 让两个或一下，保证这个索引下的值为1；
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nbits) {
            return false;
        }
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }
}
