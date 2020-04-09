package com.agile.leetcode.algorithm;

/**
 * @author liuyi
 * @since 2020/3/27
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static String lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int maxStart = 0;
        int maxLen = 0;
        int len = 1;

        for(int i=0;i<strLen;i++){
            left = i - 1;
            right = i + 1;
            while(left >= 0 && s.charAt(left) == s.charAt(i)){
                left--;
                len++;
            }

            while(right < strLen && s.charAt(right) == s.charAt(i)){
                right++;
                len++;
            }
            while(left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)){
                right++;
                left--;
                len+=2;
            }

            if(len > maxLen){
                maxLen = len;
                maxStart = left + 1;
            }
            len = 1;
        }
        return s.substring(maxStart,maxStart+maxLen);
    }

}
