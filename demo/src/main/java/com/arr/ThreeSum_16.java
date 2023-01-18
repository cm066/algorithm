package com.arr;

import java.util.Arrays;

public class ThreeSum_16 {

    public static void main(String[] args) {
        int[] nums1 = {4,0,5,-5,3,3,0,-4,-5};
        int[] nums = {-1,2,1,-4};
        int i = threeSumClosest1(nums1, -2);
        System.out.println(i);
    }

    /**
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int best = Integer.MAX_VALUE;
        int min = 10000;
        for (int i = 0; i < nums.length; i++) {
            int l = i+1, r = nums.length-1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                int min1 = Math.abs(sum-target);
                if (min1 < min){
                    best = sum;
                }
//                if (Math.abs(sum-target) < Math.abs(best-target)){
//                    best = sum;
//                }
                // 因为数组是有序的
                if (sum > target){
                    r--;
                }else if (sum < target){
                    l++;
                }else {
                    return sum;
                }
            }
        }
        return best;
    }
}
