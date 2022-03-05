package arr;

/**
 * @author Administrator
 * 41. 缺失的第一个正数 困难
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstMissingPositive {
    public static void main(String[] args) {

    }

    /**
     * 时间负载的为O(n) O(1)的额外空间
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;;
        for (int i = 0; i < nums.length; i++) {
            //将小于等于0的数全部变成n+1
            if (nums[i] <= 0){
                nums[i] = n+1;
            }
        }
        //利用本身的空间来作为一个map表
        for (int i = 0; i < n; i++) {
            int num  = Math.abs(nums[i]);
            if (num <= n){
                //这里就是把自己出现的位置变成相应的负数
                nums[num-1] = - Math.abs(nums[num-1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }
}
