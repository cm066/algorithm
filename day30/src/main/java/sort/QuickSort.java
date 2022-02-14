package sort;

import java.util.Arrays;

/**
 * @author Administrator
 * @create 2022/02/14-6:53 下午
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {11,8,3,9,7,1,2,5};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int[] a, int p, int r) {
        if (p >= r){
            return;
        }
        //分区
        int q = partition(a, p, r);
        sort(a,p,q-1);
        sort(a,q+1,r);
    }
    static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot){
                //这个是选择最后一个作为标准点，然后小于它的放在左边，大于它的放在右边
                if (i ==j){
                    ++i;
                }else {
                    //这两步就体现了快速排序不是一个稳定的，在分治的过程中，可能把位置交换了
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        //这一步的作用就是将作为标准的数放到准确的位置
        int tmp = a[i];
        a[i] =a[r];
        a[r] = tmp;
        return i;
    }
}
