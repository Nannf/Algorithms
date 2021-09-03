package com.nannf.exam.leetcode;

/**
 * @author Nannf
 * @version v1.0
 * @Description 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 输入：s = "cbbd"
 * 输出："bb"
 * @date 2021/9/2 17:56
 */
public class Solution_5 {
    // 回文的程序表达就是问题，最长也是问题
    // 这种涉及到子串的一下就想到双指针了
    // 我的起始点就错了，应该先想着暴力怎么做
    // 就是枚举所有的子串呗
    // 这种写法是超时的
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int max = 1;
        String result = s.substring(0,1);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                // 我们只遍历那些长度超过的，暴力可解
                if (j - i < max) {
                    continue;
                }
                int m = i;
                int n = j;
                boolean flag = true;
                // 终止条件是m>n
                while (m<=n) {
                    // 如果相等，需要接着比较
                    if (s.charAt(m) == s.charAt(n)) {
                        n--;
                        m++;
                    } else {
                        // 这边表示i,j的子串不是
                        flag = false;
                        break;
                    }
                }
                if (flag && (j-i+1) > max) {
                    max = j-i+1;
                    result = s.substring(i,j+1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "cbbd";
        System.out.println(new Solution_5().longestPalindrome(str));
    }
}
