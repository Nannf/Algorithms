package com.nannf.exam.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/5 9:38
 * @Description 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 * <p>
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * <p>
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 */
public class Solution_159 {

    public int lengthOfLongestSubstringTwoDistinct_BF(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 2) {
            return s.length();
        }
        int max = 0;
        char[] chars = s.toCharArray();
        // 先试试暴力
        for (int i = 0; i < chars.length; i++) {
            // 这边的j不能从0开始
            for (int j = i + max; j < chars.length; j++) {
                if (judge(chars, i, j)) {
                    max = j - i + 1;
                } else {
                    // 当遇到不对的时候，直接找下一个
                    break;
                }
            }
        }
        return max;
    }

    private boolean judge(char[] chars, int i, int j) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int m = i; m <= j; m++) {
            if (!set.contains(chars[m])) {
                count++;
                if (count > 2) {
                    return false;
                } else {
                    set.add(chars[m]);
                }
            }
        }
        return true;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 2) {
            return s.length();
        }

        // 用来判断有没有
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        set.add(chars[0]);
        // 最大长度
        int max = 1;
        // start end 是窗口
        int start = 0;
        int end = 1;
        for (; end < chars.length; end++) {
            if (!set.contains(chars[end])) {
                set.add(chars[end]);
                while (set.size() > 2) {
                    // 我们就要移动窗口，在移动之前，我们要先计算这次合法状态下的最大值
                    max = Math.max(max, end - start);
                    // 最后保留的一定是跟这个新end最近的
                    char keepChar = chars[end - 1];
                    for (int k = end - 2; k >= start; k--) {
                        if (chars[k] != keepChar) {
                            // 移除这个key
                            set.remove(chars[k]);
                            // 更新窗口
                            start = k + 1;
                            break;
                        }
                    }
                }
            }
        }
        // 我们在返回之前还要输出一次最大长度
        max = Math.max(max, end - start);
        return max;
    }


    public static void main(String[] args) {
        String str = "ccaabbb";
        System.out.println(new Solution_159().lengthOfLongestSubstringTwoDistinct(str));
    }
}
