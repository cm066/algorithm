package arr;

import java.net.InetAddress;

/**
 * @author cm
 * @create 2021/12/15-10:39 下午
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
//        int[] num1 = {1,2};
//        int[] num2 = {3,4};
        int[] num1 = {2};
        int[] num2 = {};
        double v = findMedianSortedArrays(num1, num2);
        System.out.println(v);
    }


    /**
     * 这个目前还有问题
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        //初始化i的区间，i的最小值是0，最大值是m
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax){
            //二分法取i的中间值
            int i = (iMin + iMax)/2;
            //由i确定j的位置
            int j = (m + n+1)/2-i;
            if (j != 0 && i != m && nums2[j-1] > nums1[i]){
                iMin = i +1;
            }else if (i != 0&& j != n && nums1[i-1] > nums2[j]){
                iMax = i-1;
            }else {
                //达到了两个数组的边界值，然后要考虑特殊的边界
                int maxLeft =0;
                if (i == 0){
                    maxLeft =nums2[j-1];
                } else if (j == 0){
                    maxLeft = nums1[i-1];
                }else {
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n) %2 ==1){
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m){
                    minRight = nums2[j];
                }else if (j == n){
                    minRight = nums1[i];
                }else {
                    minRight = Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0;
    }
    /**
     *
     * @param nums1 输入数组1
     * @param nums2 输入数组2
     * @return 返回两个有序数组的中位数
     * 这里要考虑两个数组的总数是偶数个还是奇数个，若是偶数个还需要记录下中间那个数的上一个数，
     * 若是奇数个则不用记录上一个，也可以考虑把两个数组放大一个数组中去，然后在计算
     *
     * 这是一个错误的解答
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int totalLength = (nums1.length + nums2.length);
        int midLength = totalLength /2;
        int midNum = 0;
        int n1 = 0,n2 = 0;
        int index = 0;
        int midNumUp = 0;
        while (index < midLength){
            int tmp1 = n1;
            int tmp2 = n2;
            if (nums1[n1] <= nums2[n2]){
                midNumUp = nums1[n1];
                n1++;
            }else {
                midNumUp = nums2[n2];
                n2++;
            }
        }
        if (totalLength %2 != 0){
            return midNumUp / 1.0;
        }else {
            return (midNum+midNumUp)/2.0;
        }
    }
}
