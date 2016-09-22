package com.zlz.leetcode.utils;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		String value = val + "";
		ListNode temp = next;
		while (temp != null) {
			value = value + " " + temp.val;
			temp = temp.next;
		}
		return value;
	}
}