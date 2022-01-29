package sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {8,5,1,3,4,9,6};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if (nums[j] > value){
                    nums[j+1] = nums[j];
                }else {
                    break;
                }
            }
            nums[j+1] = value;
        }
    }
}
