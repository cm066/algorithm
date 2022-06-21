package string;

/**
 * 383. 赎金信
 * 力扣题目链接(opens new window)
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * #思路 这道题和那个同次异构类似，
 */
public class CanConstruct {
    public static void main(String[] args) {

    }
    public boolean canConstruct(String ransomNote, String magazine) {
        //这里是假设两个字符串都是小写的,如果不是小写话可以用map这个结构进行处理 key是字符，value是字符出现的次数，最好遍历map即可
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        for (int i : record) {
            if (i < 0){
                return false;
            }
        }
        return true;
    }
}
