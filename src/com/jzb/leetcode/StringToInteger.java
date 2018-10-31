package com.jzb.leetcode;

public class StringToInteger {

	public static int myAtoi(String str) {
		boolean numEnd = false;
		char mark = '+';
		long result = 0;

		for (char c : str.toCharArray()) {
			if (c == ' ') {
				if (!numEnd) {
					continue;
				} else {
					break;
				}
			}

			if (c >= 48 && c <= 57) {
				numEnd = true;

				if (mark == '-') {
					result = result * 10 + (48 - c);
					if (result < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}
				} else {
					result = result * 10 + (c - 48);
					if (result > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
				}

			} else if (!numEnd && (c == '+' || c == '-')) {
				mark = c;
				numEnd = true;
			} else {
				break;
			}
		}
		return (int) result;
	}

	/**
	 * Given a 32-bit signed integer, reverse digits of an integer.
	 * 
	 * Example 1:
	 * 
	 * Input: 123 Output: 321 Example 2:
	 * 
	 * Input: -123 Output: -321 Example 3:
	 * 
	 * Input: 120 Output: 21 Note: Assume we are dealing with an environment which
	 * could only store integers within the 32-bit signed integer range: [−2^31, 2^31 − 1].
	 * For the purpose of this problem, assume that your function returns 0
	 * 
	 * when the reversed integer overflows.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
	}

}
