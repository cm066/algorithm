package arr;

/**
 * @author Administrator
 *去除掉数组中重复的数
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2,2,3,3,4};
        int[] nums1 = {1,2,3,4,5};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length){
            //q-p-1 > 0 这样写会有问题，会把第一个去除掉了
            if (nums[p] != nums[q] && q-p > 0){
                nums[p+1] = nums[q];
                p++;
            }
            q++;
        }
        return p+1;
    }
}
