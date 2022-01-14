package tanxin;


import java.util.Arrays;

/**
 * @author cm
 * @create 2022/1/11-11:51 下午
 * 179. 最大数 中等
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] num = {3,30,34,5,9};
        String s = largestNumber(num);
        System.out.println(s);
    }
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr,(x,y)->{
            long sx = 10,sy= 10;
            while (sx <= x){
                sx *= 10;
            }
            while (sy <= y){
                sy *= 10;
            }
            return (int) (-sy*x-y+sx*y+x);
        });
        if (numsArr[0] ==0){
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }
}
