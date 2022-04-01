package offer;

/**
 * @author cm
 * @create 2022/3/31-10:40 下午
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */
public class SingleNumbers {
    public static void main(String[] args) {
        int[] nums = {4,1,4,6};
        int[] i = singleNumbers1(nums);
        System.out.println(i);
    }
    //简单的就是数组中有一个数只出现了一次，其他的都出现了两次
    //{1,2,2,3,3,4,4}
    public static int singleNumbers(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        return tmp;
    }

    //    输入：nums = [1,2,10,4,1,4,3,3]
    //    输出：[2,10] 或 [10,2]
    //   第一种做法就是采用map，来统计出现的次数，但是这道题目要求的空间复杂度为O(1),所以不能采用这个
    // 4,1,4,6
    public static int[] singleNumbers1(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
