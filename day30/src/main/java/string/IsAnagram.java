package string;

/**
 * 242.有效的字母异位词
 */
public class IsAnagram {
    public static void main(String[] args) {
        String s= "aee", t = "eae";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            count[c -'a'] -= 1;
        }
        for (int i : count) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
