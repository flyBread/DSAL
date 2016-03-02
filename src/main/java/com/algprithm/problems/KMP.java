package com.algprithm.problems;

import java.util.Arrays;

/**
 * @author zhailzh
 * 
 * @Date 2015年11月12日——上午9:40:56
 * 
 *       KMP 给定的一个字符串，找到一个符合的比较短的字符串的p的匹配的位置
 */
public class KMP {

    public static void main(String[] args) {
	System.out.println(getTraverseindex1("BBC ABCDAB ABCDABCDABD", "ABCDABD"));
	System.out.println(getTraverseindex2("BBC ABCDAB ABCDABCDABD", "ABCDABD"));

	System.out.println(Arrays.toString(getnext("ABCDABD".toCharArray())));
    }

    // 最大的公共前缀后缀的数组
    // 为什么会有最大的前缀和后缀的说法，为了匹配的时候，不让i回溯，所以我们必须
    // 确定i开始比较的位置。
    public static int[] getNext(char[] p) {
	int[] next = new int[p.length];
	next[0] = -1;
	for (int i = 0; i < p.length; i++) {
	    int index = 0;
	    for (int j = 0; j < i; j++) {
		if (p[i - j] == p[j]) {
		    index++;
		} else {
		    break;
		}
	    }
	    next[i] = index;
	}

	return next;
    }

    // 使用递归的方法找到next的值，首先next的初始化的next[0]为-1；
    // 知道next[j] = k ，说明*p0,p1,p2,..pk-1*,pk,....*pn-(k-1),...,pn-1 ,pn-0*
    // 说明两个*之间的元素是相等的，所以我们求next[j+1]
    // *p0,p1,p2,..pk-1*,pk,pk+1,...pn-(k),*pn-(k-1),...,pn-1 ,pn-0*
    // 只需要比较pk,和 pn-k即可
    // 如果不相等，则递归到k-1的情况
    public static int[] getnext(char[] p) {
	int pLen = p.length;
	int next[] = new int[pLen];
	next[0] = -1;
	int k = -1;
	int j = 0;
	while (j < pLen - 1) {
	    // p[k]表示前缀，p[j]表示后缀
	    if (k == -1 || p[j] == p[k]) {
		++k;
		++j;
		next[j] = k;
	    } else {
		k = next[k];
	    }
	}

	return next;
    }

    // 暴力遍历的方法
    public static int getTraverseindex2(String target, String pattern) {
	if (target != null && pattern != null) {
	    char[] tar = target.toCharArray();
	    char[] pat = pattern.toCharArray();

	    int i = 0, j = 0;
	    while (i < tar.length && j < pat.length) {
		if (tar[i] == pat[j]) {
		    i++;
		    j++;
		} else {
		    /**
		     * i=i-(j-1); <br/>
		     * abcdefg<br/>
		     * abcdh<br/>
		     * 理解就是根据j走的位置，i向后走，就是回溯，直接写i++，这个是一种不正确的写法
		     * 因为i在一直的递增，没有一个回溯的过程 例如这种情况下："BBC ABCDAB ABCDABCDABD",
		     * "ABCDABD" 运行到17的位置，就会直接的增加，而错过匹配的位置
		     */
		    i = i - (j - 1);
		    // i++;
		    j = 0;
		}
	    }
	    if (i <= tar.length && j == pat.length) {
		return i - j;
	    }

	}
	return -1;

    }

    // 暴力遍历的方法
    public static int getTraverseindex1(String target, String pattern) {
	if (target != null && pattern != null) {
	    char[] tar = target.toCharArray();
	    char[] pat = pattern.toCharArray();

	    // 首先是找到第一个字符相等的位置
	    for (int i = 0; i < tar.length; i++) {
		char c = tar[i];
		// 如果这个字符和pattern的首字符相等
		if (c == pat[0]) {
		    int j = 1;
		    boolean index = true;
		    for (; j < pat.length; j++) {
			if (pat[j] != tar[i + j]) {
			    index = false;
			    break;
			}
		    }

		    if (index) {
			return i;
		    }

		} else {
		    continue;
		}

	    }

	}

	return -1;
    }
}
