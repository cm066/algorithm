package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] n1 = {4,1,2};
        int[] n2 ={1,3,4,2};
        int[] ints = nextGreaterElement1(n1, n2);
        System.out.println(Arrays.toString(ints));
    }
    /*
    单调栈的解法
    接下来就要分析如下三种情况，一定要分析清楚。

    情况一：当前遍历的元素T[i]小于栈顶元素T[st.top()]的情况
    此时满足递增栈（栈头到栈底的顺序），所以直接入栈。

    情况二：当前遍历的元素T[i]等于栈顶元素T[st.top()]的情况
    如果相等的话，依然直接入栈，因为我们要求的是右边第一个比自己大的元素，而不是大于等于！

    情况三：当前遍历的元素T[i]大于栈顶元素T[st.top()]的情况
    此时如果入栈就不满足递增栈了，这也是找到右边第一个比自己大的元素的时候。
    单调栈是用空间来换时间的
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> temp = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0 ; i< nums1.length ; i++){
            hashMap.put(nums1[i],i);
        }
        temp.add(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[temp.peek()]){
                //当前元素小于栈顶元素，所以直接入栈即可
                temp.push(i);
            }else {
                //说明当前的元素大于栈顶的元素，如果数组1存在这个元素就说明当前元素是栈顶元素的第一个大的数
                while (!temp.isEmpty() && nums2[temp.peek()] < nums2[i]){
                    //判断hash表中是否有栈顶的元素即可
                    if (hashMap.containsKey(nums2[temp.peek()])) {
                        //这一步就是在判断数组1里面是否存在栈顶元素
                        Integer index = hashMap.get(nums2[temp.peek()]);
                        res[index] = nums2[i];
                    }
                    temp.pop();
                }
                temp.add(i);
            }
        }
        return res;
    }
    /*
    暴力的解法
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int j = 0;
            //先找到相等的
            while (j < n && nums2[j] != nums1[i]){
                j++;
            }
            int k = j+1;
            //找到大于这个数的第一个数
            while (k < n && nums2[k] < nums2[j]){
                k++;
            }
            res[i] = k < n ? nums2[k] : -1;
        }
        return res;
    }
}
