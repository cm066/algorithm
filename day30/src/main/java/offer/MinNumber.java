package offer;

import java.util.Arrays;

/**
 * @author cm
 * @create 2022/3/30-12:04 上午
 */
public class MinNumber {
    public static void main(String[] args) {
        System.out.println(("330").compareTo("303"));
        int[] ints = {3,30,34,5,9};
        String s = minNumber(ints);
        System.out.println(s);
    }

    /**
     * 解题思路，根据传递性，唯一性，还有对称
     * 若拼接字符串 x + y > y + xx+y>y+x ，则 xx “大于” yy ；
     * 反之，若 x + y < y + x   x+y<y+x ，则 xx “小于” yy ；
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }
}
