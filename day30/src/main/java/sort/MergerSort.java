package sort;

import java.util.Arrays;

/**
 * 归并排序，分而治之的思想
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] arr = {11,8,3,9,7,1,2,5};
        mergerSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergerSort(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }
        mergeSort(nums,0, nums.length-1);
    }
    public static void mergeSort(int[] arr,int left,int right){
        if (left == right) {
            return;
        }
        int mid = (left + right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid+1,right);
    }


    public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound){
        int mid = rightPtr-1;
        int[] temp = new int[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;//临时数组的指针
        while (i <= mid && j <= rightBound){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid){
            temp[k++] = arr[i++];
        }
        while (j <= rightBound){
            temp[k++] = arr[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr+m] = temp[m];
        }
    }
}
