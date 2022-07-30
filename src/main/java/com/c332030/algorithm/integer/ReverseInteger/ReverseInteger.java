package com.c332030.algorithm.integer.ReverseInteger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * <p>
 * Description: ReverseInteger
 * </p>
 *
 * 注意：
 * 1. 负值，转成正值先
 * 2. 注意最小负值，取绝对值后越界
 * 3. 对比每一位时，小于不会越界，大于越界，等于才需要检查下一位
 *
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
public class ReverseInteger {

    public static void main(String[] args) {

        Consumer<Integer> consumer = x -> System.out.println(reverse(x));


        consumer.accept(0);
        consumer.accept(Integer.MIN_VALUE);
        consumer.accept(123);
        consumer.accept(120);
        consumer.accept(-2147483412);
        consumer.accept(1534236469);

    }

    private static final int[] MAX_VALUE_ARRAY = toIntArray(Integer.MAX_VALUE);

    private static final Set<Integer> ZERO_SET = new HashSet<>(Arrays.asList(0, Integer.MIN_VALUE));

    public static int reverse(int x) {

        if(ZERO_SET.contains(x)) {
            return 0;
        }

        boolean lessThenZero = x < 0;

        int[] arrReversed = toIntArray(Math.abs(x));
        reversal(arrReversed);
        if(over(arrReversed)) {
            return 0;
        }

        int i = 0;
        int val = 0;
        while (i < arrReversed.length) {
            val = val * 10 + arrReversed[i++];
        }

        if(lessThenZero) {
            val *= -1;
        }

        return val;
    }

    public static int[] toIntArray(int val) {
        return Arrays.stream(String.valueOf(val).split(""))
            .mapToInt(Integer::parseInt).toArray();
    }

    // 反转数组
    public static void reversal(int[] array) {

        int start = 0,
            end = array.length - 1;

        while (start < end) {
            int val = array[start];
            array[start] = array[end];
            array[end] = val;

            start++;
            end--;
        }

    }

    // 判断是否越界
    public static boolean over(int[] arr) {

        if(arr.length < MAX_VALUE_ARRAY.length) {
            return false;
        }

        int i = 0;
        while (i < arr.length) {

            int v1 = arr[i];
            int v2 = MAX_VALUE_ARRAY[i];

            if(v1 < v2) {
                return false;
            }

            if(v1 == v2) {
                i++;
            } else {
                return true;
            }
        }

        return true;
    }


}
