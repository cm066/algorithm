package arr;

import java.util.HashSet;
import java.util.Set;

/**
 * 第202题. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 这道其实有一个重点就是如果重复出现了，那肯定这两个数是一个死循环，所以只需要记录下出现这个数没有，如果出现了这个数，那就直接返回
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 */
public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy1(int n){
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)){
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    private static int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
    public static boolean isHappy(int num){
        Set<Integer> set = new HashSet<>();
        while (true){
            int sum = getSum(num);
            if (sum == 1){
                return true;
            }
            if (set.contains(sum)){
                return false;
            }else {
                set.add(sum);
            }
            num = sum;
        }
    }
    public static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
