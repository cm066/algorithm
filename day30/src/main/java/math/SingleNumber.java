package math;

/**
 * @author cm
 * @create 2021/12/26-8:18 下午
 * 数组中只出现了一次的数
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] num = {2,2,3};
        int i = singleNumber(num);

        System.out.println(~0);
    }
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;

    }
}
