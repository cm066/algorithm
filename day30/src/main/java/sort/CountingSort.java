package sort;

import java.util.Arrays;

/**
 * @author cm
 * @create 2022/1/31-11:29 上午
 * 桶排序和计数排序
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] a = {2,5,3,0,2,3,0,3};
        countingSort(a,a.length);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void countingSort(int[] a, int n) {
        if (n < 1){
            return;
        }
        //先要找出这组数据中的最大值，然后好确定一个范围
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max){
                max = a[i];
            }
        }
        int[] c = new int[max+1];
        //默认值就是0，所以没有必要遍历一遍然后赋值,然后直接进行统计个数
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }
        //依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i-1] + c[i];
        }
        int[] r = new int[n];
        for (int i = n-1; i >= 0; i--) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }
}
