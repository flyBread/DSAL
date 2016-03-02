package com.algprithm.problems;

/**
 * 
 * 输入一组整数，求出这组数字子序列和中最大值。也就是只要求出最大子序列的和，不必求出最大的那个序列。例如：
 * 
 * 序列：-2 11 -4 13 -5 -2，则最大子序列和为20。
 * 
 * 序列：-6 2 4 -7 5 3 2 -1 6 -9 10 -2，则最大子序列和为16。
 */
public class Al03MaxSubArraySum {

  public static void main(String[] args) {
    int[] value = new int[] { -6, 2, 4, -7, 5, 3, 2, -1, 6, -9, 10, -2 };
    // n的三次方的算法
    int max = getmaxO3(value);
    // n的二次方的算法，在上面的基础上面改进
    int max1 = getmaxO2(value);

    int max2 = getmaxO(value);
    System.out.println(max);

    System.out.println(max1);

    System.out.println(max2);
  }

  /**
   * 首先，我们重温将一个问题用动态规划方法处理的准则： “最优子结构”、“子问题重叠”、“边界”和“子问题独立”。
   * 在本问题中，我们可以将子序列与其子子序列进行问题分割。 最后得到的状态转移方程为： MaxSum[i] = Max{ MaxSum[i-1] +
   * A[i], A[i]};
   */
  private static int getmaxO(int[] a) {
    int maxSum = 0, thisSum = 0;
    for (int j = 0; j < a.length; j++) {
      // 循环的相加，0,1,2,3，。。。j
      thisSum += a[j];
      if (thisSum > maxSum)
        maxSum = thisSum;
      else if (thisSum < 0)
        thisSum = 0;
    }
    return maxSum;
  }

  private static int getmaxO2(int[] ary) {
    int max = 0;
    for (int i = 0; i < ary.length; i++) {
      int temp = 0;
      for (int j = i; j < ary.length; j++) {
        temp = temp + ary[j];
        if (temp > max) {
          max = temp;
        }
      }
    }

    return max;
  }

  public static int getmaxO3(int[] ary) {
    int max = 0;
    for (int i = 0; i < ary.length; i++) {
      for (int j = i + 1; j < ary.length; j++) {
        int temp = sum(i, j, ary);
        if (temp > max) {
          max = temp;
        }
      }
    }

    return max;
  }

  private static int sum(int i, int j, int[] ary) {

    int sum = 0;
    for (int k = i; k <= j; k++) {
      sum = sum + ary[k];
    }
    return sum;
  }

}
