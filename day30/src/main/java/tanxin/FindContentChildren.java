package tanxin;

import java.util.Arrays;

/**
 * @author cm
 * @create 2022/1/14-9:58 下午
 * 简单 分发糖果
 */
public class FindContentChildren {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,4};
        int i = findContentChildren(g, s);
        System.out.println(i);
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ret = 0;
        int gIndex= 0,sIndex =0;
        while (gIndex <g.length &&  sIndex < s.length){
            if (g[gIndex] <= s[sIndex]){
                ret++;
                gIndex++;
                sIndex++;
            }else {
                sIndex++;
            }
        }
        return ret;
    }
}
