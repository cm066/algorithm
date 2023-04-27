package com.other;

public class MyPow {

    public static void main(String[] args) {

        System.out.println(Math.pow(2, -8));
        double v = myPow(2.00000, -8);
        System.out.println(v);
    }

    /*
        实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
        示例 1：
        输入：x = 2.00000, n = 10
        输出：1024.00000
        没有利用到二分法到思想

     */
    public static double myPow(double x, int n) {
        double ret = x;
        int len = 0;
        len = n > 0 ? n - 1 : -n + 1;
        while (len > 0) {
            if (n > 0) {
                ret = ret * x;

            } else {
                ret = ret / x;
            }
            len--;
        }
        return ret;
    }
    public static double myPow2(double x, int n) {
        double ret = x;
        int len = 0;
        len = n > 0 ? n - 1 : -n + 1;
        while (len > 0) {
            if (n > 0) {
                ret = ret * x;

            } else {
                ret = ret / x;
            }
            len--;
        }
        return ret;
    }

    public static double myPow1(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow4(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul4(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

}
