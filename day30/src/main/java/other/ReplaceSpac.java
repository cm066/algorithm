package other;

/**
 * @author cm
 * @create 2022/4/5-1:14 下午
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50ywkd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReplaceSpac {
    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = replaceSpace(s);
        System.out.println(s1.equals("We%20are%20happy."));
    }
    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            if (c != ' '){
                builder.append(c);
            }else {
//                builder.append('%').append('2').append('0');
                builder.append("%20");
            }
        }
        return builder.toString();
    }
}
