package com.jzb.leetcode;

public class ReverseInteger {

    public static int reverse(int x) {

        int temp = 0;
        int tail = 0, result = 0;

        while (x != 0) {
            tail = x % 10;
            temp = result;
            result = 10 * result + tail;
            x = x / 10;
        }

        if ((result - tail) / 10 != temp) {
            return 0;
        }

        return result;
    }

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     *
     * Example 1:
     *
     * Input: 123
     * Output: 321
     * Example 2:
     *
     * Input: -123
     * Output: -321
     * Example 3:
     *
     * Input: 120
     * Output: 21
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit
     * signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your
     * function returns 0 when the reversed integer overflows.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
