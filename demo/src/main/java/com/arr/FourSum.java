package com.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {

    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 4){
            return quadruplets;
        }

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 因为数组是有序的
            if ((long )nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target){
                break;
            }
            // 第一个数和最后三个数相加都小于target，那没有四个数相加等于tarhet
            if ((long)nums[i] + nums[length-1]+nums[length-2]+nums[length-3] < target){
                continue;
            }
            for (int j = i+1; j < length-2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j+1, right = length-1;
                while (left < right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //去重操作
                        while (left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if (sum < target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
