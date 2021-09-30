package exam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/30 15:45
 * @Description a-z 1-26
 * A-Z 1-26
 * 给定一串字符串 ffdd aaa aaa bbb aaa ccc
 * 以空格为界限，拆分字符串
 * 以第一个为基准，从后五个选择最接近基准的字符串
 */
public class StringExam {
    private static final Map<Character, Integer> map = new HashMap<>();

    static {
        for (char c = 97; c <= 122; c++) {
            map.put(c, c - 96);
        }
        for (char c = 65; c <= 90; c++) {
            map.put(c, c - 64);
        }
    }

    public static void main(String[] args) {
       String[] strs = {"ffdd","aaa","zzz","ccc","aaaa","hhhh"};
        System.out.println(new StringExam().process(strs));
    }


    public String process(String[] strs) {
        if (strs == null || strs.length != 6) {
            throw new IllegalArgumentException("非法的参数");
        }
        int minIndex = -1;
        int minGap = Integer.MAX_VALUE;

        int baseValue = convertStringToInt(strs[0]);

        for (int i = 1; i < 6; i++) {
            int gap = Math.abs(convertStringToInt(strs[i]) - baseValue);
            if (gap < minGap) {
                minIndex = i;
                minGap = gap;
            }
        }

        return strs[minIndex];
    }

    private static int convertStringToInt(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(map.get(str.charAt(i)));
        }
        return Integer.valueOf(sb.toString());
    }


}
