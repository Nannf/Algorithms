package com.nannf.leetcode;

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
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int max = 1;
        String result = s.substring(0);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int m = i;
                int n = j;
                while (m<=n) {
                    if (s.indexOf(m) == s.indexOf(n)) {
                        n--;
                        m++;
                    }
                }
            }
        }
    }
}
