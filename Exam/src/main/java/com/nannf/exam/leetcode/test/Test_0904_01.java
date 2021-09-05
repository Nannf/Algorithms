package com.nannf.exam.leetcode.test;

import java.util.*;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/4 21:48
 * @Description 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
 * <p>
 * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
 * <p>
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * <p>
 * 所有输入整数都在 [-10000，10000] 范围内。
 * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
 * 输入点没有顺序。
 */
public class Test_0904_01 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(p1[1]);
        map.put(p1[0], list);

        if (map.containsKey(p2[0])) {
            map.get(p2[0]).add(p2[1]);
        } else {
            List<Integer> list2 = new ArrayList<>();
            list2.add(p2[1]);
            map.put(p2[0], list2);
        }

        if (map.containsKey(p3[0])) {
            map.get(p3[0]).add(p3[1]);
        } else {
            List<Integer> list3 = new ArrayList<>();
            list3.add(p3[1]);
            map.put(p3[0], list3);
        }

        if (map.containsKey(p4[0])) {
            map.get(p4[0]).add(p4[1]);
        } else {
            List<Integer> list4 = new ArrayList<>();
            list4.add(p4[1]);
            map.put(p4[0], list4);
        }
        // 必须只有两个x
        if (map.size() != 2) {
            return false;
        }

        int yGap = -1;
        int xGap = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            // 有且仅有两个y
            if (entry.getValue().size() != 2) {
                return false;
            }
            if (xGap == -1) {
                xGap = entry.getKey();
            } else {
                xGap = Math.abs(xGap - entry.getKey());
            }
            // 两个y的间距要相同
            int t = Math.abs(entry.getValue().get(0) - entry.getValue().get(1));
            if (yGap == -1) {
                yGap = t;
            } else {
                if (yGap != t) {
                    return false;
                }
            }
        }
        return xGap == yGap;
    }

    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};

        if (new Test_0904_01().validSquare(p1, p2, p3, p4)) {
            System.out.println("bingo");
        }
    }
}
