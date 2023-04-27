package com.str;

public class LengthOfLastWord {
    public static void main(String[] args) {

        String s = "luffy is still joyboy";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }

    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        int length = split[split.length - 1].length();
        return length;
    }

    public int lengthOfLastWord1(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
