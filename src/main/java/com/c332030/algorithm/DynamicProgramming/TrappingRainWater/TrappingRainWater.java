package com.c332030.algorithm.DynamicProgramming.TrappingRainWater;

/**
 * <p>
 *
 * Description: TrappingRainWater 接雨水
 *
 * 找出当前位置左右的最高高度，减去当前高度，就是当前位置可接的雨水
 *
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
public class TrappingRainWater {

    public static void main(String[] args) {

        System.out.println(trap(new int[] {
            0,1,0,2,1,0,1,3,2,1,2,1
        }));

        System.out.println(trap(
            new int[] {
                4,2,0,3,2,5
            }
        ));

    }

    public static int trap(int[] height) {

        int length = height.length;
        if (length == 0) {
            return 0;
        }

        int[] leftHeight = new int[length];
        leftHeight[0] = height[0];
        for (int i = 1; i < length; ++i) {
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
        }

        int[] rightHeight = new int[length];
        rightHeight[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; --i) {
            rightHeight[i] = Math.max(rightHeight[i + 1], height[i]);
        }

        int all = 0;
        for (int i = 0; i < length; ++i) {
            all += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }

        return all;
    }

}
