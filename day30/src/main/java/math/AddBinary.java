package math;

/**
 * @author cm
 * @create 2021/12/26-7:53 下午
 * 二进制求和
 */
public class AddBinary {
    public static void main(String[] args) {

    }

    public String addBinary2(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = Math.max(a.length(),b.length()),carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length()-1-i)-'0'):0;
            carry += i < b.length() ? (b.charAt(b.length() - 1-i) - '0') : 0;
            stringBuilder.append((char)(carry %2+'0'));
            carry = carry /2;
        }
        if (carry > 0){
            stringBuilder.append('1');
        }
        stringBuilder.reverse();

        return stringBuilder.toString();
    }
    /**
     * 如果字符串超过 3333 位，不能转化为 Integer
     * 如果字符串超过 6565 位，不能转化为 Long
     * 如果字符串超过 500000001500000001 位，不能转化为 BigInteger
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }
    /**
     * 这个思路太复杂
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a, String b) {
        if (a == null || b == null ){
            return null;
        }
        if (a.length() == 0 && b.length() != 0){
            return b;
        }
        if (b.length() == 0 && a.length() != 0){
            return a;
        }
        char tmp = '0';
        StringBuilder builder = new StringBuilder();
        int len = a.length() > b.length() ? b.length() : a.length();
        int a1 = a.length() -1;
        int b2 = b.length() -1;
        while (builder.length() <= len){
            if (builder.length() == 0){
                if (a.charAt(a1) == '1' && b.charAt(b2) == '1'){
                    builder.append('0');
                    tmp = '1';
                    a1--;
                    b2--;
                }
            }
            if ((a.charAt(a1) == '1' && b.charAt(b2) == '1' && tmp != '1')){
                tmp = '1';
                builder.append('0');
                a1--;
                b2--;
            }
            if ((a.charAt(a1) == '1' && b.charAt(b2) == '1' && tmp != '1')){
                tmp = '1';
                builder.append('1');
                a1--;
                b2--;
            }
            if ((a.charAt(a1) != '1' && b.charAt(b2) != '1' && tmp != '0')){
                tmp = '0';
                builder.append('0');
                a1--;
                b2--;
            }
        }

        return builder.reverse().toString();
    }
}
