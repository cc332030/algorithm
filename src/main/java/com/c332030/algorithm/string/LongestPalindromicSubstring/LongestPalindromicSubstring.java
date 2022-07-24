package com.c332030.algorithm.string.LongestPalindromicSubstring;

import java.util.function.Function;

/**
 * <p>
 * Description: LongestPalindromicSubstring 最长回文子串
 *
 * 方案1：创建一个 n*n 的数组，统计 1-n * n-1 是否相等，找出最长的
 * 方案2：中心扩展法，既然是回文串，那中间位置两边的也相等，找出左右两边的边界
 *
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        Function<String, String> function = LongestPalindromicSubstring::longestPalindrome;

        System.out.println(function.apply("babad"));
        System.out.println(function.apply("cbbd"));
        System.out.println(function.apply("ccd"));
        System.out.println(function.apply("aba"));

    }

    public static String longestPalindrome(String s) {

        int len = s.length();
        if(len < 2) {
            return s;
        }

        char[] chars = s.toCharArray();

        // 避免没有回文
        String result = s.substring(0, 1);
        for (int i = 0; i < len - 1;) {

            int left = i - 1;
            int right = i + 1;
            while (chars[i] == chars[right]) {

                right++;

                int lenTmp = right - i;
                if(result.length() < lenTmp) {
                    result = s.substring(i, right);
                }

                // 后面的字符全相同
                if(right == len) {
                    return result;
                }
            }
            i = right;

            if(left < 0) {
                continue;
            }

            while (left >= 0 && right < len && chars[left] == chars[right]) {
                left--;
                right++;
            }

            int lenTmp = right - left;
            if(result.length() < lenTmp) {
                result =  s.substring(left + 1, right);
            }

        }

        return result;
    }

}
