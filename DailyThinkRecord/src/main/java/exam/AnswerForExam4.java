package exam;

import java.math.BigInteger;
import java.util.Random;

//有大约10万个数字，每个数字大小在30左右，求它们的乘积。
//要求：
//1、运行堆内存只有4M（java -Xmx4m）；
//2、耗时小于2秒。
//输入：数字数组。
//输出：这些数字的乘积。
public class AnswerForExam4 {
    // 随机数个数
    private static final int NUMBER_COUNT = 100000;
    // 每个随机数的大小[1,31]
    private static final int NUMBER_RANGE = 30;
    // 保证 (NUMBER_RANGE+1) ^ BATCH_NUMBER < Integer.MAX_VALUE = 2,147,483,647;
    private static final int BATCH_NUMBER = 5;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 全部使用BigInteger数组内存会溢出
        int[] inputs = buildInput();
        // Max Integer = 2,147,483,647;
        // 39 ^ 6      = 3,518,743,761;
        // 一个极端的情况是所有的值全是39，这样当6个39相乘时，就超过了int可以表示的最大值，所以我们5个为一组
        // 所以我们可以先5个为一组相乘,这样可以把新建BigInteger对象的个数减少5倍，才能保证运行时间控制在2s内
        preDeal(inputs);
        // 用result存储最终的结果
        BigInteger result = new BigInteger("1");
        int i = 0;
        while (i < NUMBER_COUNT - BATCH_NUMBER) {
            result = result.multiply(new BigInteger(inputs[i] + ""));
            i = i + BATCH_NUMBER;
        }
        result = result.multiply(new BigInteger(inputs[i] + ""));

        System.out.println(result);
        long cost = System.currentTimeMillis() - start;
        System.out.println("cost + " + cost + "ms");
    }

    private static void preDeal(int[] inputs) {
        int i = 0;
        while (i < inputs.length - BATCH_NUMBER) {
            for (int j = i + 1; j < i + BATCH_NUMBER; j++) {
                inputs[i] = inputs[i] * inputs[j];
            }
            i = i + BATCH_NUMBER;
        }
        for (int j = i + 1; j < inputs.length; j++) {
            inputs[i] = inputs[i] * inputs[j];
        }
    }

    private static int[] buildInput() {
        Random random = new Random(9527);
        int[] ints = new int[NUMBER_COUNT];
        for (int i = 0; i < NUMBER_COUNT; i++) {
            // 这边得加1，不然10w个很大几率会有0
            ints[i] = random.nextInt(NUMBER_RANGE) + 1;
        }
        return ints;
    }
}
