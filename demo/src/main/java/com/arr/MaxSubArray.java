package com.arr;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSubArray {
    public static void main(String[] args) {

    }

    /*
        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        输出：6
        解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
        采用动态规划的来解决的
        f(i)=max{f(i−1)+nums[i],nums[i]}
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre, pre + num);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
}
