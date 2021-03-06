package com.zlz.utils.sort;

import java.util.Arrays;

/**
 * @author zhailz
 * 归并排序，稳定的算法，最好的情况O(nlogn),最坏的情况O(nlogn),平均的情况是O(nlogn)
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, Integer.MAX_VALUE, 7, 0, Integer.MAX_VALUE, 2, 3,
        5, 7, 0, 1, 2, 3, 8 };
    System.out.println(Arrays.toString(arrays));
    System.out.println(arrays.length);
    arrays = mergeSort(arrays);
    System.out.println(Arrays.toString(arrays));
    System.out.println(arrays.length);

  }

  public static int[] mergeSort(int[] arrays) {
    return arrayMergeSort(arrays, 0, arrays.length - 1);
  }

  private static int[] arrayMergeSort(int[] arrays, int i, int j) {
    if (i < 0 || j > arrays.length - 1) {
      throw new IllegalArgumentException("");
    }
    if (i < j) {
      int m = (i + j) / 2;
      arrayMergeSort(arrays, i, m);
      arrayMergeSort(arrays, m + 1, j);
      arrayMergeSortContentNoFlag(arrays, i, m, j);
    }
    return arrays;
  }

  public static void arrayMergeSortContent(int[] arrays, int i, int m, int j) {
    int first = m - i + 1;
    int second = j - m;

    int[] firsta = new int[first + 1];
    int[] seconda = new int[second + 1];

    for (int k = i; k <= m; k++) {
      firsta[k - i] = arrays[k];
    }
    for (int k = m + 1; k <= j; k++) {
      seconda[k - m - 1] = arrays[k];
    }

    firsta[first] = Integer.MAX_VALUE;
    seconda[second] = Integer.MAX_VALUE;

    int ff = 0;
    int ss = 0;
    for (int k = i; k <= j; k++) {
      if (firsta[ff] < seconda[ss]) {
        arrays[k] = firsta[ff];
        ff++;
      } else {
        arrays[k] = seconda[ss];
        ss++;
      }
    }
  }

  public static void arrayMergeSortContentNoFlag(int[] arrays, int i, int m, int j) {
    int first = m - i + 1;
    int second = j - m;

    int[] firsta = new int[first];
    int[] seconda = new int[second];

    // ʼ
    for (int k = i; k <= m; k++) {
      firsta[k - i] = arrays[k];
    }
    for (int k = m + 1; k <= j; k++) {
      seconda[k - m - 1] = arrays[k];
    }

    int ff = 0;
    int ss = 0;
    int k = i;
    for (; k <= j && ff < firsta.length && ss < seconda.length; k++) {
      if (firsta[ff] < seconda[ss]) {
        arrays[k] = firsta[ff];
        ff++;
      } else {
        arrays[k] = seconda[ss];
        ss++;
      }
    }

    if (ff <= firsta.length - 1) {
      for (; ff < firsta.length; k++, ff++) {
        arrays[k] = firsta[ff];
      }
    }

    if (ss <= seconda.length - 1) {
      for (; ff < seconda.length; k++, ss++) {
        arrays[k] = seconda[ss];
      }
    }
  }
}
