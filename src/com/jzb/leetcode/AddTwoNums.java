package com.jzb.leetcode;

public class AddTwoNums {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	// time : O(max(m, n))
	// space : O(max(m, n))
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode result = new ListNode(0);
		int index = 0;
		ListNode point = result;

		int carry = 0;
		while (p1 != null || p2 != null) {
			
			int sum = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
			ListNode p3 = new ListNode(sum % 10);
			carry = sum / 10;
			
			if (index == 0) {
				result = p3;
				point = p3;
			} else {
				result.next = p3;
				result = result.next;
			}
			
			index++;
			p1 = (p1 == null ? null : p1.next);
			p2 = (p2 == null ? null : p2.next);
		}
		
		if (carry == 1) {
			result.next = new ListNode(1);
		}
		
		return point;
		
    }

	/**
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except the
	 * number 0 itself.
	 * 
	 * Example:
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 
	 * Explanation: 342 + 465 = 807.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		p1.next = new ListNode(8);
		//p1.next.next = new ListNode(4);
		
		ListNode p2 = new ListNode(0);
		//p2.next = new ListNode(6);
		//p2.next.next = new ListNode(4);
		
		ListNode result = addTwoNumbers(p1, p2);
		
		for (; result != null; result = result.next) {
			System.out.println(result.val);
		}
	}
}
