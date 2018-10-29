package com.jzb.leetcode;

import java.util.ArrayList;

public class ZigZagConversion {


    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int round = numRows * 2 - 2;
        int halfRound = numRows - 1;
        boolean isGo = true;
        for (int i = 0; i < s.length(); i++) {
            int j = i % round;
            if (j == halfRound) {
                list.get(halfRound).append(s.charAt(i));
                isGo = false;
            } else if (j == 0) {
                list.get(0).append(s.charAt(i));
                isGo = true;
            } else {
                if (isGo) {
                    list.get(j).append(s.charAt(i));
                } else {
                    int cur = halfRound - i % halfRound;
                    list.get(cur).append(s.charAt(i));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder one : list) {
            result.append(one);
        }

        return result.toString();

    }

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string s, int numRows);
     * Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     *
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 1));
    }
}
