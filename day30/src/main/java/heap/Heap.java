package heap;

import java.util.PriorityQueue;

/**
 * @author Administrator
 */
public class Heap {
    //数组，从下标1开始存储数据，然后就不用加1了
    private int[] a;
    //堆可以存储的最大数据个数
    private int n;
    //堆中已经存储的数据个数
    private int count;

    public Heap(int capacity){
        a = new int[capacity+1];
        n = capacity;
        count = 0;
    }

    /**
     * 构建大顶堆，自下而上堆化
     * @param data
     */
    public void insert(int data){
        if (count >= n){
            //堆满了
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]){
            //自下往上堆化
            swap(a,i,i/2);
            i = i/2;
        }
    }

    /**
     * 移除堆顶元素
     */
    public int removeMax(){
        if (count == 0){
            return -1;
        }
        int result = a[1];
        a[1] = a[count];
        --count;
        heapify(a,count,1);
        return result;
    }

    /**
     * 移除堆顶元素体现的就是自上而下的堆化过程
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true){
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]){
                maxPos = i*2;
            }
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]){
                maxPos = i*2+1;
            }
            if (maxPos == i){
                break;
            }
            swap(a,i,maxPos);
            i = maxPos;
        }

    }

    /**
     *  将下标i和j的位置进行交换
     * @param i
     * @param j
     */
    private void swap(int[] b, int i, int j){
        int tmp = b[i];
        b[i] = b[j];
        b[j] = b[i];
    }

    /**
     * 构建堆，和刚才的构建堆的思想不太一样
     * @param a
     * @param n
     */
    private  void buildHeap(int[] a, int n){
        for (int i = n/2; i >= 1; --i) {
            heapify(a,n,i);
        }
    }

    /**
     *
     * @param a 要构建的数组
     * @param n 表示的数据的个数，数组a中的数据从下标1到n的位置
     */
    public void sort(int[] a,int n){
        buildHeap(a,n);
        int k = n;
        while (k > 1){
            swap(a,1,k);
            --k;
            heapify(a,k,1);
        }
    }
    public static void main(String[] args) {

    }
}
