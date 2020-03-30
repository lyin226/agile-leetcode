package com.agile.leetcode.algorithm;

/**
 * @author liuyi
 * @since 2020/3/30
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abcbade";
        System.out.println(longestPalindrome(s));

    }

    /**
     * 暴力判断字符串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String result = "";
        int max = 0;
        for (int i=0; i< s.length(); i++) {
            for (int j=i+1; j<= s.length(); j++) {
                String test = s.substring(i, j);
                if(isPalindrome(test) && test.length() > max) {
                    result = test;
                    max = test.length();
                }
            }
        }
        return result;
    }

    /**
     * 判断是否回文
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
