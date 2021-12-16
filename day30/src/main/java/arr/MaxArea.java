package arr;

import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 * @author Administrator
 */
public class MaxArea {
    public static void main(String[] args) {

    }

    /**
     * @param nums
     * @return
     * 解题的思路：可以采用暴力遍历的方式，但是这样会造成时间复杂度很高，并且有很多是没有必要必要的，
     * 所以采用双指针的方式来解决
     */
    public static int maxArea(int[] nums){
        int result = 0 ;
        int left = 0;
        int right = nums.length;
        while (left < right){
            if (nums[left] < nums[right]){
                result = Math.max(result,(right-left)*nums[left]);
                left++;
            }else {
                result = Math.max(result,(right-left)*nums[right]);
                right--;
            }
        }
        return result;
    }
}
