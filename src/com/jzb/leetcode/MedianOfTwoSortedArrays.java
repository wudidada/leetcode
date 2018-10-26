package com.jzb.leetcode;

public class MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            m = m + n; n = m - n;
            m -= n;
        }

        int imin = 0, imax = m;

        while (imin <= imax) {
			int i = (imin + imax) / 2;
			int j = (m + n + 1) / 2 - i;
        	if (i > imin && nums2[j - 1] > nums1[i]) {
        		imin++;
	        } else if (i < imax && nums1[i - 1] > nums2[j]) {
        		imax--;
	        } else {
        		int maxLeft = 0;
        		if (i == 0) {
        			maxLeft = nums2[j - 1];
		        } else if (j == 0) {
        			maxLeft = nums1[i -1];
		        }

		        if ( (m + n) % 2 == 1 ) { return maxLeft; }

		        int minRight = 0;
		        if (i == m) { minRight = nums2[j]; }
		        else if (j == n) { minRight = nums1[i]; }
		        else { minRight = Math.min(nums2[j], nums1[i]); }

		        return (maxLeft + minRight) / 2.0;
	        }
        }

        return 0.0;
    }

	

	/**
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * Find the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 * You may assume nums1 and nums2 cannot be both empty.
	 * 
	 * Example 1:
	 * nums1 = [1, 3] nums2 = [2]
	 * The median is 2.0 
	 * 
	 * Example 2:
	 * nums1 = [1, 2] nums2 = [3, 4]
	 * The median is (2 + 3)/2 = 2.5
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,2};
		int[] nums2 = new int[] {};

		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
