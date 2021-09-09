package com.nannf.exam.leetcode;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/9 22:45
 * @Description 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 */
public class Solution_326 {

    public boolean isPowerOfThree(int n) {
        if (n ==1) {
            return true;
        }
        return dfs(n, n);

    }

    private boolean dfs(int n, int last) {
        if (n == 0) {
            return false;
        }

        if (last == 3 && n == 1) {
            return true;
        }
        return dfs(n / 3, n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_326().isPowerOfThree(45));
    }
}
