package arr;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums  = {-4,-1,1,2};
        int[] num1 = {1,1,1,0};
        int i = threeSumClosest(num1, 100);
        System.out.println(i);
    }

//没有必要去重操作，大不了多几次的比较,还是选择了去重操作，这样会少比较很多次 这题去重不去重其实都是可以的，
    /**
     *  if (Math.abs(sum-target) < Math.abs(best-sum)){
     *                     best = sum;
     *                 }有这一步的比较，相同就不会进行替换操作，如果没有这一步考虑去重的话可能会有优化的空间
     */

    public static int threeSumClosest(int[] nums, int target){
        int best = 10000000;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if (sum == target){
                    return sum;
                }
                if (Math.abs(sum-target) < Math.abs(best-target)){
                    best = sum;
                }
                if (sum > target){
                    int rtmp = right-1;
                    while (left < rtmp && nums[rtmp] == nums[right]){
                        rtmp--;
                    }
                    right = rtmp;
                }else {
                    int ltmp = left+1;
                    while (ltmp < right && nums[ltmp] == nums[left]){
                        ltmp++;
                    }
                    left = ltmp;
                }
            }
        }
        return best;
    }
    /**
     *
     * @param nums
     * @param target
     * @return
     * 这道题和三数之和等于0最大的区别就在于这个接近目标不用去重，所以不能考虑去重的问题
     * 下面这个解法有问题，三个数最接近目标数，就相当于这个三个数的和
     */
    public static int threeSumClosest1(int[] nums, int target){
        int result = 0;
        Arrays.sort(nums);
        int len = nums.length-1;
//        int tmp  = 0;//保存上一步骤的
        for (int i = 2; i < nums.length; i++) {
            //这里还有问题，万一是负数呢，这里不全部成正数了吗
            int tmp = Math.abs(nums[i-2]+nums[i-1]+nums[i])-target;
            if(i == 2){
                result = tmp;
            }else {
                result = Math.min(result,tmp);
            }
        }
        return result+1;
    }
}
