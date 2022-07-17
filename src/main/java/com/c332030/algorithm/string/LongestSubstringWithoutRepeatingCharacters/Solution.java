package com.c332030.algorithm.string.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Description: Solution
 * </p>
 *
 * @author c332030
 * @version 1.0
 */

class Solution {

    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public int lengthOfLongestSubstring (String s) {

        if(null == s || s.length() == 0) {
            return 0;
        }

        int len = 0, strLen = s.length();
        int start = 0,end = 0;

        Map<Character, Integer> map = new HashMap<>(strLen);
        while(end < strLen) {

            char ch = s.charAt(end);
            Integer index = map.get(ch);

            if(null != index && index >= start) {
                len = Math.max(len, end - start);
                start = index + 1;
            }

            map.put(ch, end++);
        }

        return len;
    }
}
