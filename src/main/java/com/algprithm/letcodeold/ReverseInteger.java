package com.algprithm.letcodeold;

/**
 * @author zhailzh
 * 
 *         Reverse digits of an integer.
 *         Example1: x = 123, return 321
 *         Example2: x = -123, return -321
 */
public class ReverseInteger {

  int reverse(int x) {
    int y = Math.abs(x), z = x == y ? 1 : -1;
    long tmp = 0;
    while (y != 0) {
      tmp = tmp * 10 + y % 10;
      y /= 10;
    }
    if (z * tmp > Integer.MAX_VALUE || z * tmp < Integer.MIN_VALUE) return 0;
    return (int) (z * tmp);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
