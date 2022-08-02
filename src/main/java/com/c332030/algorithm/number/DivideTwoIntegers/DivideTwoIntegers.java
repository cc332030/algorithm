package com.c332030.algorithm.number.DivideTwoIntegers;

import java.util.function.BiConsumer;

/**
 * <p>
 * Description: DivideTwoIntegers 两数相除
 * </p>
 *
 * <a href="https://leetcode.cn/problems/divide-two-integers/">两数相除</a>
 *
 * @author c332030
 * @version 1.0
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {

        BiConsumer<Integer, Integer> consumer = (v1, v2) -> System.out.println(getResult(v1, v2));

        consumer.accept(10, 3);
        consumer.accept(7, -3);

    }


    public static int getResult(int num1, int num2) {

        boolean isSmallThenZero = num1 < 0 | num2 < 0;

        int result = 0;
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        while ((num1 = num1 - num2) > 0) {
            result++;
        }

        return isSmallThenZero ? -result : result;
    }

}
