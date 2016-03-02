package com.algprithm.problems;

public class Al09MinCoin {

  // 动态规划 所得出的值与前面的相关，即当前子问题的解由上一问题推出,由上一状态迁移到当前状态，受前面状态的影响
  // 这是与分支法的本质区别 分治法没有状态迁移 分治法的子问题不受前面结果的影响
  /*
   * 当硬币为零时 d(0)=0 d(1)=d(1-1)+1 d(2)=d(2-1)+1 d(3)=d(3-1)+1
   * 
   * d(3)=d(3-3)+1; d(3)=min{d(3-1)+1,d(3-3)+1};//取硬币个数的最小值 动态规划
   */
  public static void main(String[] args) {
    int a[] = { 1, 3, 5 };

    // 最少需要几枚硬币
    int count = 11;
    NumberOfCoin(a, count);
  }

  private static void NumberOfCoin(int[] a, int count) {
    int Min[] = new int[count + 1];// 储存该硬币所需硬币的最小数目
    Min[0] = 0;//
    int minCoin = 0;//
    for (int i = 1; i < Min.length; i++) {
      minCoin = i;// i是不可变的，每一个都是和前一个相关的
      for (int j = 0; j < a.length; j++) {
        if (a[j] <= i && Min[i - a[j]] + 1 < minCoin) {
          minCoin = Min[i - a[j]] + 1;
        }
      }
      System.out.println(minCoin + "   i=" + i);
      Min[i] = minCoin;// 时间复杂度为O(n^2)
    }
    System.out.println(Min[11]);
  }

}
