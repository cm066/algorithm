package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubboSort {
    public static void main(String[] args) {
        int[] nums = {8,5,1,3,4,9,6};
        bubboSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void bubboSort(int[] nums){
        int len = nums.length;
        if (len == 0){
            return;
        }
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len-i-1; j++) {
                if (nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }
}
