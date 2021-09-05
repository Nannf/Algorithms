package com.nannf.exam.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/5 13:32
 * @Description
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class Solution_242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 转换成两个hashmap然后逐一比较
        Map<Character,Integer> sMap = buildHashMap(s);
        Map<Character,Integer> tMap = buildHashMap(t);

        for (Map.Entry<Character,Integer> entry : sMap.entrySet()) {
            if (tMap.containsKey(entry.getKey()) && tMap.get(entry.getKey()).equals(entry.getValue())) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> buildHashMap(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> ans = new HashMap<>();
        for (char c : chars) {
            if (ans.containsKey(c)) {
                ans.put(c,ans.get(c)+1);
            }else {
                ans.put(c,1);
            }
        }
        return ans;
    }
}
