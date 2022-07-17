package com.c332030.algorithm.string.BeautyValue;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Description: 美丽值 </p>
 *
 * @author c332030（袁兴旺）
 * @version 1.0
 *
 * 1781. 所有子字符串美丽值之和
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 *
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 示例 2：
 *
 * 输入：s = "aabcbaa"
 * 输出：17
 *
 */
public class BeautyValue {

    // TODO 未完成
    public static void main(String[] args) {

        // 计算出所有子串
        // 分别计算美丽值

        String str = "";

        List<String> substrings = new ArrayList<>();


        int val = substrings.stream().map(BeautyValue::beautySum).reduce(0, Integer::sum);
        System.out.println(val);

    }

    public static int beautySum(String s) {

        Map<Integer, Integer> map = new HashMap<>();
        s.chars().forEach(ch -> map.compute(ch, (k, v) -> Optional.ofNullable(v).orElse(0) + 1));

        AtomicInteger max = new AtomicInteger();
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
        map.values().forEach(val -> {
            max.set(Math.max(val, max.get()));
            min.set(Math.min(val, min.get()));
        });

        return max.get() - min.get();
    }

}
