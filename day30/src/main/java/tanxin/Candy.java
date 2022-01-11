package tanxin;

/**
 * @author cm
 * @create 2022/1/10-11:55 下午
 * 分发糖果 困难
 */
public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,2,2,1};
        int[] ratings1 = {1,3,5,3,2,1};
        int candy = candy1(ratings1);
        System.out.println(candy);
    }

    public static int candy1(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1,dec = 0,pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i-1]){
                dec = 0;
                pre = ratings[i] == ratings[i-1] ? 1: pre+1;
                ret += pre;
                inc = pre;
            }else {
                //这里的作用就相当于是把递减的一部分当做成了递增部分来解决，就是逆向的思维
                dec++;
                if (dec == inc){
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }
    /**
     * 采用遍历两次的方法来左，先从左到右，然后在从右往左
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && (ratings[i]>ratings[i-1])){
                left[i] = left[i-1]+1;
            }else {
                left[i] = 1;
            }
        }
        int right = 0;
        int ret = 0;
        for (int i = n-1; i >= 0; i--) {
            if (i < n-1 && (ratings[i] > ratings[i+1])){
                right++;
            }else {
                right = 1;
            }
            ret += Math.max(left[i],right);
        }
        return ret;
    }
}
