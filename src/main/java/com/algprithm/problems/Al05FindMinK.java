package com.algprithm.problems;

import com.algorithm.sort.QuickSort;
import com.data.Heap;
import com.data.createData.DataFromFile;

/**
 * @author zhailzh 需找最小的K个元素
 */
public class Al05FindMinK {

  public static void main(String[] args) {
    int[] arrays = DataFromFile.readIntData(0, 100);
    // 第一种方法，首先利用快排排好序列，然后调出前面的k个最小的，效率是：O（n*logn+k）=O（n*logn）。
    QuickSort.quickSort(arrays);
    int k = 4;
    for (int i = 0; i < k; i++) {
      System.out.print(arrays[i] + " ");
    }

    // 第二种，维护一个k的数据,然后遍历n个数据，保持k个数据的顺序
    // 效率就是：整趟下来，总的时间复杂度平均下来为：n*O（k）=O（n*k）
    // int[] mink = findMink1(arrays, k);
    // for (int i = 0; i < k; i++) {
    // System.out.print(mink[i] + " ");
    // }

    // 第三种，如果k比较大的话，我们可以对k的数据结构进行优化，利用小顶堆的特点
    // 效率就是：总费时O（k+（n-k）*logk）=O（n*logk）
    int[] mingheap = findMink2(arrays, 4);
    Heap.printMAXHeapByOrder(mingheap);
  }

  public static int[] findMink2(int[] arrays, int k) {
    // 初始化
    int[] mingheap = new int[k];
    for (int i = 0; i < k; i++) {
      mingheap[i] = arrays[i];
    }

    Heap.creatMAXheap(mingheap);

    for (int i = k; i < arrays.length; i++) {
      int temp = arrays[i];
      // 遍历每一个值，维护大顶堆
      sortHead(temp, mingheap);
    }
    return mingheap;
  }

  private static void sortHead(int temp, int[] mingheap) {

    // 比最大的值还要大，直接的返回
    if (temp >= mingheap[0]) {
      return;
    } else {
      mingheap[0] = temp;
      Heap.creatMAXheap(mingheap);
    }

  }

  public static int[] findMink1(int[] arrays, int k) {
    // 初始化
    int[] mink = new int[k];
    for (int i = 0; i < k; i++) {
      mink[i] = arrays[i];
    }

    // 给前k个元素进行排序
    QuickSort.quickSort(mink);

    for (int i = k; i < arrays.length; i++) {
      sortk(arrays[i], mink);
    }
    return mink;
  }

  /**
   * value 和 mink中的元素，进行比较，确定value在mink中的位置
   */
  public static void sortk(int value, int[] mink) {

    // 特殊的情况,比最大的还要大，直接的返回
    if (value >= mink[mink.length - 1]) {
      return;
    }

    // 比最小的还要小，直接的赋值
    if (value < mink[0]) {
      mink[0] = value;
    }

    // 位置处于mink的中间值

    for (int i = mink.length - 1; i > 0; i--) {
      if (value < mink[i]) {
        mink[i] = mink[i - 1];
      } else {
        mink[i + 1] = value;
      }
    }

  }
}
