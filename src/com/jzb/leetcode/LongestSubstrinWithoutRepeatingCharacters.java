package com.jzb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstrinWithoutRepeatingCharacters {
	
	public static int lengthOfLongestSubstring(String s) {
		StringBuffer buffer = new StringBuffer();
		
		int max = 0;
        for (int i = 0; i < s.length(); i++) {
        	int index;
        	if ((index = buffer.lastIndexOf(s.charAt(i) + "")) >= 0) {
        		max = max > buffer.length() ? max : buffer.length();
        		if (index < buffer.length()) {
        			buffer = new StringBuffer(buffer.substring(index + 1));
        		} else {
        			buffer = new StringBuffer();
        		}
        	}
        	
        	buffer = buffer.append(s.charAt(i));
        }
        
        max = max > buffer.length() ? max : buffer.length();
        
        return max;
    }
	
	/**
	 * Sliding Window
	 */
	public static int lengthOfLongestSubstring2(String s) {
		int size = s.length();
		int ans = 0, i = 0, j = 0;
		
		Set<Character> set = new HashSet<>();
		
		while (i < size && j < size) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		
		return ans;
    }
	
	/**
	 * Sliding Window Optimized
	 */
	public static int lengthOfLongestSubstring3(String s) {
		int ans = 0, i = 0, j = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		while (j < s.length()) {
			char c = s.charAt(j);
			if (map.containsKey(c)) {
				i = Math.max(map.get(c), i);
			}
			
			ans = Math.max(ans, j - i + 1);
			map.put(c, ++j);
		}
		
		return ans;
    }
	
	/**
	 * Given a string, find the length of the longest substring without repeating
	 * characters.
	 * 
	 * Example 1:
	 * 
	 * Input: "abcabcbb" Output: 3 
	 * Explanation: The answer is "abc", with the length of 3.
	 * 
	 * Example 2:
	 * 
	 * Input: "bbbbb" Output: 1 
	 * Explanation: The answer is "b", with the length of 1.
	 * 
	 * Example 3:
	 * 
	 * Input: "pwwkew" Output: 3 
	 * Explanation: The answer is "wke", with the length of 3.
	 * 				Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 * @param args
	 */

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring3("pwwkew"));
	}

}
