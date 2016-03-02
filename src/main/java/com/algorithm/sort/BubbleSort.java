package com.algorithm.sort;

import java.util.Arrays;

/**
 * �ص㣺stable sort��In-place sort ˼�룺ͨ��������������ˮ�е�����һ����С����ð��������ĺ�ð������ �����ʱ�䣺O(n^2)
 * �������ʱ�䣺O(n^2)����Ȼ��Ҳ���Խ��иĽ�ʹ���������ʱ��ΪO(n)
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, 6, 7, 0, 4, 2, 3, 5, 7, 0, 1, 2, 3, 8 };
    arrays = bubbleSort(arrays);
    System.out.println(Arrays.toString(arrays));
  }

  public static int[] bubbleSort(int[] arrays) {

    for (int j = 0; j < arrays.length; j++) {
      // �����arrays.lenth -1 �� j+1 �������ݣ�˵��˳���Ѿ��ź��ˣ���û�б�Ҫ�ٴε�ѭ����
      for (int i = arrays.length - 1; i > j; i--) {
        if (arrays[i] < arrays[i - 1]) {
          int temp = arrays[i - 1];
          arrays[i - 1] = arrays[i];
          arrays[i] = temp;
        }
      }
    }
    return arrays;
  }

  public static int[] bubbleSortImpove(int[] arrays) {

    boolean flag = false;
    for (int j = 0; j < arrays.length; j++) {
      if (flag)
        return arrays;
      flag = true;
      // �����arrays.lenth -1 �� j+1 �������ݣ�˵��˳���Ѿ��ź��ˣ���û�б�Ҫ�ٴε�ѭ����
      for (int i = arrays.length - 1; i > j; i--) {
        if (arrays[i] < arrays[i - 1]) {
          int temp = arrays[i - 1];
          arrays[i - 1] = arrays[i];
          arrays[i] = temp;
          flag = false;
        }
      }
    }

    return arrays;
  }
}
