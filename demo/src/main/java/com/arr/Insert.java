package com.arr;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] newInterval = {4,8};
        int[][] insert = insert(intervals, newInterval);
        for (int[] ints : insert) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /*
       给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
       在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
       示例 1：
       输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
       输出：[[1,5],[6,9]]
       输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
       输出：[[1,2],[3,10],[12,16]]
       解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
       // 找到一个区间的值的第最后一个数大于要插入的区间，然后插入最后一个区间的最后一个数小于
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right){
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            }else if (interval[1] < left){
                // 左侧也是无交集
                ansList.add(interval);
            }else {
                // 要找到左侧在的第一个区间和右侧在的第一个区间
                // 与插入区间有交集，计算它们的并集
                // 左边找最小的，左边找最大的
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
