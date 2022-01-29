package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {8,5,1,3,4,9,6};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void selectSort(int[] nums){
        int min;
        for (int i = 0; i < nums.length; i++) {
            min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            if (min != i){
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }
    }
}
