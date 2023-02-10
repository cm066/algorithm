package com.arr;

import java.awt.dnd.InvalidDnDOperationException;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int[] nums1 = {0,1,2,2,3,0,4,2};
        int i = removeElement(nums1, 2);
        System.out.println(i);
    }

    // 输入：nums = [3,2,2,3], val = 3
    //输出：2, nums = [2,2]
    //解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
    public static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = 0, index = 0;
        while (index < nums.length) {

            if (nums[index] != val) {
                nums[ret] = nums[index];
                ret++;
            }
            index++;
        }
        return ret;
    }
}
