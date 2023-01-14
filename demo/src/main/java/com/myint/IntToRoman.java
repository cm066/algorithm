package com.myint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntToRoman {
   static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static void main(String[] args) {

    }
    public static String intToRoman1(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            // 两部体现了贪心的思想，每次都从最大的开始
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value){
                num -= value;
                builder.append(symbol);
            }
            if (num == 0){
                break;
            }
        }
        return builder.toString();
    }
    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 输入: num = 3
     * 输出: "III"
     * 示例 2:
     *
     * 输入: num = 4
     * 输出: "IV"
     * 示例 3:
     *
     * 输入: num = 9
     * 输出: "IX"
     * 示例 4:
     *
     * 输入: num = 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例 5:
     *
     * 输入: num = 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * 1 <= num <= 3999
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        if (num == 0){
            return null;
        }
        int[]  nums = new int[4];
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (num < 0){
            int a = num % 10;
            nums[index++] = a;
            num /= num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                if (nums[i] == 5){
                    builder.append("V");
                }if (nums[i] == 4){
                    builder.append("IV");
                }if (nums[i] == 9){
                    builder.append("IX");
                }else {
                    if (nums[i] % 5 != 0){
                        builder.append("V");
                        nums[i] = nums[i] - 5;
                    }
                    for (int j = 0; j < nums[i]; j++) {
                        builder.append("I");
                    }
                }
            }
        }
        return builder.reverse().toString();
    }

}
