package likou;

/**
 * @author cm
 * @create 2022/3/22-10:17 下午
 */
public class CountBits {
    public static void main(String[] args) {
//        Integer.bitCount()
    }

    /**
     * Brian Kernighan 算法
     * x=x & (x−1) 该运算将 xx 的二进制表示的最后一个 11 变成 00
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] ret = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ret[i] = countOnes(i);
        }
        return ret;
    }
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0){
            x = x & (x-1);
            ones++;
        }
        return ones;
    }

    /**
     * 动态规划记住高位有效位，后一个肯定比前一个数多一个1，但是当遇到进位的时候又要从之前开始
     * @param n
     * @return
     */
    public int[] countBitsDp(int n) {
        int[] bits = new int[n+1];
        int highBit = 0;
        for (int i = 0; i <= n; i++) {
            //这一步就是判断是否进位了，进位的化就会导致1的个数减少
            if ((i&(i-1)) == 0){
                highBit = i;
            }
            bits[i] = bits[i-highBit];
        }
        return bits;
    }
}
