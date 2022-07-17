package com.c332030.algorithm.string.LongestSubstringWithoutRepeatingCharacters;

/**
 * <p>
 * Description: LongestSubstringWithoutRepeatingCharacters 最长不重复子串
 *
 * <a href="https://www.nowcoder.com/practice/5947ddcc17cb4f09909efa7342780048">
 *     LongestSubstringWithoutRepeatingCharacters
 * </a>
 *
 * 结题思路：
 *  1. 定义 start, end 游标，定义一个 map 存储每个字符上次出现的问题；
 *  2. 从 map 取 end 位置字符上次出现的位置 index；
 *  3. 存在且大于等于 start 时，计算从 start 到 end 位置的字符串长度，和 len 相比，取最大值；
 *  4. 并移动 start 到 index 的下一个位置，不存在则记录字符本次位置，移动 end 游标；
 *  5. end 等于字符串长度时退出循环
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {


        String str = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";

        System.out.println(str.length());

        Object result = new Solution().lengthOfLongestSubstring(str);
        System.out.println(result);
    }

}