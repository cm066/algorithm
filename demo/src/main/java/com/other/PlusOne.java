package com.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] plusOne1(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] ret = new int[len + 1];
        ret[0] = 1;
        return ret;
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = 0;
            if (i == digits.length - 1) {
                sum = digits[i] + 1 + index;
            } else {
                sum = digits[i] + index;
            }
            index = sum / 10;
            list.add(sum % 10);
        }
        if (index != 0) {
            list.add(index);
        }
        int size = list.size();
        int[] ret = new int[size];
        index = size - 1;
        for (Integer integer : list) {
            ret[index--] = integer;
        }
        return ret;
    }
}
