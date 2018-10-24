package com.jzb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	// time : O(n^2)
	// space : O(1)
	public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        
        throw new IllegalArgumentException("No two sum solution.");
    }
	
	// time	: O(n)
	// space : O(n)
	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			
			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution.");
	}
	
	
	
	//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	//You may assume that each input would have exactly one solution, and you may not use the same element twice.
	//Example:
	//Given nums = [2, 7, 11, 15], target = 9,
	//Because nums[0] + nums[1] = 2 + 7 = 9,
	//return [0, 1].
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		System.out.println(Arrays.toString(twoSum2(nums, target)));
	}

}
