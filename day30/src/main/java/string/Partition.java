package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cm
 * @create 2022/1/9-1:51 下午
 */
public class Partition {

    public static void main(String[] args) {
        Partition partition = new Partition();
        String s = "aab";
        List<List<String>> partition1 = partition.partition(s);
        System.out.println(partition1);
    }
    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i],true);
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i+1][j-1];
            }
        }
        dfs(s,0);
        return ret;
    }

    private void dfs(String s, int i) {
        if (i == n){
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            if (f[i][j]){
                ans.add(s.substring(i,j+1));
                dfs(s,j+1);
                ans.remove(ans.size()-1);
            }
        }
    }
}
