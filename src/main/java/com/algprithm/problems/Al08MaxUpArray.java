package com.algprithm.problems;

/**
 * 求一个序列的最大非降子序列的长度，采用的是动态规划的方法 说明：最长非降子序列不要求连续
 */
public class Al08MaxUpArray {

  public static void main(String[] args) {

    int[] array = new int[] { 1, 2, 3, 2, 6, 8, 9, 3, 6 };

    int length = getMaxUpArray(array);
    System.out.println(length);
  }

  private static int getMaxUpArray(int[] A) {
    int len = 1;
    // 首先是子问题解的保存
    int[] d = new int[A.length];
    // 状态转移方程
    // a(i) = max(1 , a(j)+1) 其中i>j,并且A[i]> A[j] 不要求连续
    // 如果发生状态转移，那么最后的一个元素一定是最大的，不然就要维护原来的长度
    for (int i = 0; i < A.length; i++) {
      d[i] = 1;
      // 不要求连续的情况下，需要的判断的条件就有了两个max(1 , a(j)+1)，A[i]> A[j]
      for (int j = 0; j < i; ++j) {
        // 状态方程的转移的确定，这个是重中之重！
        boolean ji = A[j] <= A[i];
        boolean dji = d[j] + 1 > d[i];
        if (ji && dji) {
          d[i] = d[j] + 1;
        }
      }
      if (d[i] > len)
        len = d[i];
    }

    for (int i = 0; i < d.length; i++) {
      System.out.println("数组的截止到：" + i + " 最大非降子序列的长度为： " + d[i]);
    }

    return len;
  }
}
