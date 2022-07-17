package com.c332030.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Description: minimum-depth-of-binary-tree 二叉树最小深度
 * 题目描述
 *  求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 *  Given a binary tree, find its minimum depth.
 *      The minimum depth is the number of nodes along the shortest path
 *      from the root node down to the nearest leaf node.
 * 示例1
 *  输入
 *      {1,2,3,4,5}
 *  输出
 *      2
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
public class MinimumDepthOfBinaryTree {

}

class Solution {

    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int run (TreeNode root) {

        if(null == root) {
            return 0;
        }

        int deepLen = 1;

        List<TreeNode> nodes = new ArrayList<>(1);
        nodes.add(root);
        while(true) {

            List<TreeNode> nodes2 = new ArrayList<>();
            for(TreeNode node: nodes) {

                TreeNode nodeLeft = node.left;
                TreeNode nodeRight = node.right;

                if(null == nodeLeft && null == nodeRight) {
                    return deepLen;
                }

                if(null != nodeLeft) {
                    nodes2.add(nodeLeft);
                }
                if(null != nodeRight) {
                    nodes2.add(nodeRight);
                }
            }
            nodes = nodes2;
            deepLen++;
        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}
