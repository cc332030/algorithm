package com.c332030.algorithm.array.MidInTwoAscArray;

import java.util.Arrays;

/**
 * <p>
 * Description: 两个递增数组的中位数
 *
 * <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">
 *     中位数
 * </a>
 *
 * 结题思路：
 *  1. 合并到一个数组后取中间位置
 *  2. 从两个数组第一个元素开始，每次移动两个数组当前索引对应的较小的数所在数组的索引，移到中间位置取中位数（类似于第一种，只是没用合并数组）
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
public class MidInTwoAscArray {

    public static void main(String[] args) {

        System.out.println(getMid(new int[]{
            1, 5, 7
        }, new int[]{
            2, 4, 8
        }));

        System.out.println(getMid(new int[]{
            1, 3
        }, new int[]{
            2
        }));

        System.out.println(getMid(new int[]{
            1, 2
        }, new int[]{
            3
        }));

        System.out.println(getMid(new int[]{
        }, new int[]{
            3
        }));

        System.out.println(getMid(new int[]{
        }, new int[]{
            3, 4
        }));

        System.out.println(getMid(new int[]{
            3, 4
        }, new int[]{

        }));

    }

    static double getMid(int[] nums1, int[] nums2) {

        System.out.println("num1: " + Arrays.toString(nums1) + ", num2: " + Arrays.toString(nums2));

        int size1 = nums1.length;
        int size2 = nums2.length;
        int size = size1 + size2;

        int index1 = 0,
            index2 = 0;

        int moveTimes = 0;
        int midTimes = size / 2 + 1;
        boolean isOuShu = size % 2 == 0;

        int mid = -1;

        while (index1 < nums1.length || index2 < nums2.length) {

            int val;

            ++moveTimes;

            if (index1 == nums1.length) {
                val = nums2[index2++];
            } else if (index2 == nums2.length) {
                val = nums1[index1++];
            } else if (nums1[index1] < nums2[index2]) {
                val = nums1[index1++];
            } else {
                val = nums2[index2++];
            }

            if (isOuShu) {
                if (moveTimes == midTimes - 1) {
                    mid = val;
                }
            }
            if (moveTimes == midTimes) {
                if (mid != -1) {
                    return (mid + val) / 2.0;
                }
                return val;
            }
        }

        return mid;

    }


}
