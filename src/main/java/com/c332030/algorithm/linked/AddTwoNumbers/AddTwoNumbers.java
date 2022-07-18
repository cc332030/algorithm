package com.c332030.algorithm.linked.AddTwoNumbers;

import java.util.Arrays;
import java.util.Iterator;

/**
 * <p>
 * Description: AddTwoNumbers 两数相加
 *
 * <a href="https://leetcode.cn/problems/add-two-numbers/">...</a>
 *
 * steps
 * 1. 其中一个为空，返回另一个
 * 2. 计算节点的值，直到至少有一个的 next 为 null
 * 3. 拼接不为空的那个的 next，注意要进位
 * 4. 如果两个的 next 都为 null，拼接进位
 *
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        // {
        //     ListNode node1 = getLinkByArray(2,4,3);
        //     ListNode node2 = getLinkByArray(5,6,4);
        //
        //     System.out.println(node1);
        //     System.out.println(node2);
        //
        //     System.out.println(addTwoNumbers(node1, node2));
        // }

        System.out.println();
        {
            ListNode node1 = getLinkByArray(9,9,9,9,9,9,9);
            ListNode node2 = getLinkByArray(9,9,9,9);

            System.out.println(node1);
            System.out.println(node2);

            System.out.println(addTwoNumbers(node1, node2));
        }

        // System.out.println();
        // {
        //     ListNode node1 = getLinkByArray(9,9,9,9);
        //     ListNode node2 = getLinkByArray(9,9,9,9,9,9,9);
        //
        //     System.out.println(node1);
        //     System.out.println(node2);
        //
        //     System.out.println(addTwoNumbers(node1, node2));
        // }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(null == l1) {
            return l2;
        }

        if(null == l2) {
            return l1;
        }

        ListNode resultNode = null;

        ListNode nodeInWhile = null;
        ListNode l1InWhile = l1;
        ListNode l2InWhile = l2;

        int rest = 0;
        while (null != l1InWhile && null != l2InWhile){

            int result = l1InWhile.val + l2InWhile.val + rest;

            rest = result / 10;
            result = result % 10;

            ListNode node = new ListNode(result);
            if(null == nodeInWhile) {
                resultNode = nodeInWhile = node;
            } else {
                nodeInWhile.next = node;
                nodeInWhile = node;
            }

            l1InWhile = l1InWhile.next;
            l2InWhile = l2InWhile.next;

        }

        if(null == l1InWhile) {
            while (null != l2InWhile) {

                if(rest > 0) {

                    int result = l2InWhile.val + rest;

                    l2InWhile.val = result %10;
                    rest = result / 10;
                }

                nodeInWhile.next = l2InWhile;
                nodeInWhile = nodeInWhile.next;

                l2InWhile = l2InWhile.next;
            }
        }

        if(null == l2InWhile) {
            while (null != l1InWhile) {

                if(rest > 0) {
                    int result = l1InWhile.val + rest;

                    l1InWhile.val = result % 10;
                    rest = result / 10;
                }

                nodeInWhile.next = l1InWhile;
                l1InWhile = l1InWhile.next;
                nodeInWhile = nodeInWhile.next;
            }
        }

        // 最后进位
        if(rest > 0) {
            nodeInWhile.next = new ListNode(rest);
        }

        return resultNode;
    }

    private static ListNode getLinkByArray(int... ints) {

        Iterator<Integer> iterator = Arrays.stream(ints).iterator();

        ListNode firstNode = new ListNode(iterator.next());

        ListNode node = firstNode;
        while (iterator.hasNext()) {

            ListNode nextNode = new ListNode(iterator.next());
            node.next = nextNode;

            node = nextNode;

        }

        return firstNode;
    }

}
