package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cm
 * @create 2022/3/28-7:23 下午
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 */
public class Fib {
    public static void main(String[] args) {
        int fib = fibDb(5);
        System.out.println(fib);
    }

    //第一种采用递归的思想,这个可以采用记忆集进行优化
    public static int fib(int n) {
        if (n < 2){
            return n;
        }

        return fib(n-1)+fib(n-2);
    }
    public static int fibDb(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int q =0,p = 0, r= 1;
        for (int i = 2; i <= n; i++) {
            q  = p;
            p = r;
            r = (q+p) % MOD;
        }
        return r;
    }
}
