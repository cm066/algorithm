package math;

/**
 * @author cm
 * @create 2021/12/26-3:12 下午
 */
public class Divide {
    public static void main(String[] args) {
        int divide = divide(11, 3);
        System.out.println(divide);
    }
    public static int divide(int dividend, int divisor) {
        //考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE){
            if (divisor == 1){
                return Integer.MIN_VALUE;
            }
            if (dividend == -1){
                return Integer.MAX_VALUE;
            }
        }
        //考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE){
            return dividend == Integer.MIN_VALUE?1:0;
        }
        if (divisor == 0){
            return 0;
        }
        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况,这个主要是为了不超出范围
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right){
            int mid = left + ((right-left)>>1);
            boolean check = quickAdd(divisor,mid,dividend);
            if (check){
                ans = mid;
                if (mid == Integer.MAX_VALUE){
                    break;
                }
                left = mid +1;
            }else {
                right = mid-1;
            }
        }
        return rev ? -ans:ans;
    }
    //快速乘
    public static boolean quickAdd(int y, int z,int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0){
            if ((z & 1) !=0){
                // 需要保证 result + add >= x
                if (result < x-add){
                    return false;
                }
                result += add;
            }
            if (z != 1){
                // 需要保证 add + add >= x
                if (add < x -add) {
                    return false;
                }
                add += add;
            }
            z >>= 1;
        }
        return true;
    }
}
