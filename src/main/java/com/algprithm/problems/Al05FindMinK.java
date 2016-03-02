package com.algprithm.problems;

import com.algorithm.sort.QuickSort;
import com.data.Heap;
import com.data.createData.DataFromFile;

/**
 * @author zhailzh ������С��K��Ԫ��
 */
public class Al05FindMinK {

  public static void main(String[] args) {
    int[] arrays = DataFromFile.readIntData(0, 100);
    // ��һ�ַ������������ÿ����ź����У�Ȼ�����ǰ���k����С�ģ�Ч���ǣ�O��n*logn+k��=O��n*logn����
    QuickSort.quickSort(arrays);
    int k = 4;
    for (int i = 0; i < k; i++) {
      System.out.print(arrays[i] + " ");
    }

    // �ڶ��֣�ά��һ��k������,Ȼ�����n�����ݣ�����k�����ݵ�˳��
    // Ч�ʾ��ǣ������������ܵ�ʱ�临�Ӷ�ƽ������Ϊ��n*O��k��=O��n*k��
    // int[] mink = findMink1(arrays, k);
    // for (int i = 0; i < k; i++) {
    // System.out.print(mink[i] + " ");
    // }

    // �����֣����k�Ƚϴ�Ļ������ǿ��Զ�k�����ݽṹ�����Ż�������С���ѵ��ص�
    // Ч�ʾ��ǣ��ܷ�ʱO��k+��n-k��*logk��=O��n*logk��
    int[] mingheap = findMink2(arrays, 4);
    Heap.printMAXHeapByOrder(mingheap);
  }

  public static int[] findMink2(int[] arrays, int k) {
    // ��ʼ��
    int[] mingheap = new int[k];
    for (int i = 0; i < k; i++) {
      mingheap[i] = arrays[i];
    }

    Heap.creatMAXheap(mingheap);

    for (int i = k; i < arrays.length; i++) {
      int temp = arrays[i];
      // ����ÿһ��ֵ��ά���󶥶�
      sortHead(temp, mingheap);
    }
    return mingheap;
  }

  private static void sortHead(int temp, int[] mingheap) {

    // ������ֵ��Ҫ��ֱ�ӵķ���
    if (temp >= mingheap[0]) {
      return;
    } else {
      mingheap[0] = temp;
      Heap.creatMAXheap(mingheap);
    }

  }

  public static int[] findMink1(int[] arrays, int k) {
    // ��ʼ��
    int[] mink = new int[k];
    for (int i = 0; i < k; i++) {
      mink[i] = arrays[i];
    }

    // ��ǰk��Ԫ�ؽ�������
    QuickSort.quickSort(mink);

    for (int i = k; i < arrays.length; i++) {
      sortk(arrays[i], mink);
    }
    return mink;
  }

  /**
   * value �� mink�е�Ԫ�أ����бȽϣ�ȷ��value��mink�е�λ��
   */
  public static void sortk(int value, int[] mink) {

    // ��������,�����Ļ�Ҫ��ֱ�ӵķ���
    if (value >= mink[mink.length - 1]) {
      return;
    }

    // ����С�Ļ�ҪС��ֱ�ӵĸ�ֵ
    if (value < mink[0]) {
      mink[0] = value;
    }

    // λ�ô���mink���м�ֵ

    for (int i = mink.length - 1; i > 0; i--) {
      if (value < mink[i]) {
        mink[i] = mink[i - 1];
      } else {
        mink[i + 1] = value;
      }
    }

  }
}
