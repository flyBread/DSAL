package com.algprithm.letcode;

/**
 * @author zhailzh
 * 
 * @Date 2015年12月3日——下午7:19:03
 * 
 * 回文数字，不适用额外的空间
 */
public class PalindromeNumber {

	public static void main(String[] args) {
			System.out.println(isPalindromeNumber(121));

	}

	
	public static boolean isPalindromeNumber(int num){
		int sum = num;
		int temp = 0;
		while(sum != 0){
			temp = temp*10 + sum %10;
			sum = sum /10;
		}
		return temp == num;
	}
	
}
