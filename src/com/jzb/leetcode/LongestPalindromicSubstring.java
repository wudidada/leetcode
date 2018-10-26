package com.jzb.leetcode;

public class LongestPalindromicSubstring {

	/**
	 * 原始方案 比较慢
	 * @param s
	 * @return
	 */
    public static String longestPalindrome(String s) {
    	
    	for (int i = s.length(); i >= 1; i--) {
    		int k = 0;
    		for (int j = 0; i + j <= s.length(); j++) {
    			boolean isBreak = false;
    			k = j;
    			for (; k <= j + (i - 1) / 2; k++) {
    				
    				//System.out.println(s.charAt(k) + "<=>" + s.charAt(i - k - 1 + j) );
    				
    				if (s.charAt(k) != s.charAt(j + j - k + i - 1)) {
    					isBreak = true;
    					break;
    				}
    			}
    			
    			k--;
    			
    			if (!isBreak && k == j + (i - 1) / 2) {
    				int lastIndex = j + i > s.length() ? 0 : j + i;
    				return s.substring(j, lastIndex);
    			}
    		}
    	}
        return "";
    }

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: "cbbd"
     * Output: "bb"
     */
    public static void main(String[] args) {
    	System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}
}
