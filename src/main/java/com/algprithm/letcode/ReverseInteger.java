package com.algprithm.letcode;

/**
 * @author zhailzh
 * 
 * @Date 2015年12月2日——下午4:56:04
 * 
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {

	int reverse(int x) {
        // 先分离出x的数值部分和符号部分
        int y = Math.abs(x), z = x == y ? 1 : -1;
        // 将y反向放于一个long中，这样可以避免越界
        long tmp = 0;
        while (y != 0) {
            tmp = tmp * 10 + y % 10;
            y /= 10;
        }
        // 判断是否越界
        if (z*tmp > Integer.MAX_VALUE || z*tmp < Integer.MIN_VALUE) return 0;
        // 否则返回翻转后的值
        return (int) (z*tmp);
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
