package com.jzb.leetcode;

import java.util.Arrays;

public class CountingBits_338 {

    public int[] countBits(int num) {
        int[] count= new int[num + 1];

        count[0] = 0;
        int power = 1;
        for (int i = 1; i <= num; i++) {
            // 2^n只有一个1
            if (i == power * 2) {
                power = i;
                count[i] = 1;
            } else if (i % 2 == 0) {
                // 为偶数，则为去掉最高位的一对应的数包含的1的数量加1
                count[i] = count[i - power] + 1;
            } else {
                // 为奇数，则在前面一个数的基础上加1
                count[i] = count[i - 1] + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountingBits_338 test = new CountingBits_338();
        int[] result = test.countBits(5);
        System.out.println(Arrays.toString(result));
    }
}
