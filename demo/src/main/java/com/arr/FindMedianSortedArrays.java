package com.arr;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {3,5,8,9};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    /**
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 这一步的作用是什么？这一步有必要吗？
        if (nums1.length > nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int m = nums1.length;
        int n = nums2.length;;
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax){
            // 二分法取中间值
            int i = (iMin + iMax) / 2;
            // 由i觉得j的位置,为什么公式是这样的？
            int j = (m + n +1)/2 - i;
            // 这是处理上有下左不越界问题
            if (j != 0 && i != m && nums2[j-1] > nums1[i]){
                iMin = i + 1;
                // 这里是处理上右下左不越界的问题
            }else if (i != 0 && j != n && nums1[i-1] > nums2[j]){
                iMax = i -1;
            }else{
                // 达到两个数组的的边界值了，然后要考虑特殊的边界值
                int maxLeft = 0;
                 if (i == 0){
                     maxLeft = nums2[j-1];
                 }else if (j == 0){
                     maxLeft = nums1[i-1];
                 }else {
                     maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                 }
                 // 奇数个
                 if ((m+n) % 2 == 1){
                     return maxLeft;
                 }
                 int minRight = 0;
                 if (i == m){
                     minRight = nums2[j];
                 } else if (j == n) {
                     minRight = nums1[i];
                 }else {
                     minRight = Math.min(nums1[i],nums2[j]);
                 }
                 return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }
}
