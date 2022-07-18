package com.c332030.algorithm.array.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Description: TwoSum 两数之和
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
public class TwoSumToNum {

    public static void main(String[] args) {

        int[] nums = new int[] {2,7,11,15};
        int target = 9 ;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            int val = nums[i];
            int result = target - val;

            Integer index = map.get(result);
            if(null == index) {
                map.put(val, i);
            } else {
                return new int[]{index, i};
            }

        }

        return null;
    }

}
