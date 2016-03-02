package com.algprithm.letcode;

import java.util.HashMap;

/**
 * @author zhailzh
 * 
 * @Date 2015年11月13日——下午9:04:21
 * 
 *       最长的没有重复的字符串 . Given a string, find the length of the longest substring
 *       without repeating characters. For example, the longest substring
 *       without repeating letters for "abcabcbb" is "abc", which the length is
 *       3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters chars = new LongestSubstringWithoutRepeatingCharacters();
		int value = chars.lengthOfLongestSubstring1("abcabcbbpoiuytrewq");
		System.out.println(value);

		int value2 = chars.lengthOfLongestSubstring2("abcabcbbpo");
		System.out.println(value2);

		int value3 = chars.lengthOfLongestSubstring3("abcabcbbpo");
		System.out.println(value3);

		int value4 = chars.lengthOfLongestSubstring("abcabcbbpo");
		System.out.println(value4);
	}

	public int lengthOfLongestSubstring(String s) {
		int[] occ = new int[256];

		int max = 0, counter = 0, start = 1;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (occ[ch] >start) {
				max = Math.max(max, counter);
				counter -= occ[ch] - start + 1;
				start = occ[ch] + 1;
			}
			//还是对这个开始的处理，感觉很巧妙，并且start 开始是1，感觉比较的合乎逻辑，常理
			//但是 occ[ch] = i+1,就比较的奇怪了,只能够理解为下一个元素的位置或者，开始的位置
			occ[ch] = i + 1;
			++counter;

		}

		return Math.max(max, counter);
	}

	// 采用动态规划的方法，这个需要好好的想一想啊
	public int lengthOfLongestSubstring3(String s) {
		char[] content = s.toCharArray();
		HashMap<Character, Integer> charindex = new HashMap<Character, Integer>();
		int temp = 0, max = 0, start = 0;
		for (int i = 0; i < content.length; i++) {
			char c = content[i];
			if (!charindex.containsKey(c) || charindex.get(c) < start) {
				temp++;
				charindex.put(c, i);
			} else {
				max = max > temp ? max : temp;
				start = charindex.get(c) + 1;
				temp = i - start + 1;
				charindex.put(c, i);
			}
		}
		return max > temp ? max : temp;
	}

	// 避免回溯的遍历的方法
	public int lengthOfLongestSubstring2(String s) {
		if (s != null && !s.isEmpty()) {
			char[] content = s.toCharArray();
			HashMap<Character, Integer> charindex = new HashMap<Character, Integer>();
			int temp = 0, max = 0;
			int start = 0;
			for (int i = 0; i < content.length; i++) {
				char c = content[i];
				// 开始的位置是i，结束的位置是与之相等的哪一个位置j
				int j = i;
				for (; j < content.length; j++) {
					char cj = content[j];
					if (!charindex.containsKey(cj)) {
						temp++;
						charindex.put(cj, j);
					} else {
						if (temp > max) {
							max = temp;
						}
						// 如果这个时候，开始的字符有相等的,这个是相等字符的位置
						int ak = charindex.get(cj);
						// j 为结束字符的位置，为了不让回溯，直接把i置为j,然后计算出temp的值
						// a1,a2,...,ai,ai+1,...,ak,ak+1,....aj,aj+1
						// 这个时候，ai到aj的距离为temp，
						// 把i置为j之后，temp减少的距离为，ai 到 ak-1 之间的元素 k-i 所以：
						temp = temp - (ak - start);

						for (int k = start; k < ak + 1; k++) {
							charindex.remove(content[k]);
						}
						start = ak + 1;
						charindex.put(cj, j);
						i = j;
						break;
					}
				}
			}
			return max > temp ? max : temp;
		}
		return 0;
	}

	// 暴力匹配的方法
	public int lengthOfLongestSubstring1(String s) {
		if (s != null && !s.isEmpty()) {
			char[] content = s.toCharArray();
			int temp = 1, max = 1;
			HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
			for (int i = 0; i < content.length; i++) {
				char c = content[i];
				chars.put(c, 1);
				for (int j = i + 1; j < content.length; j++) {
					char cj = content[j];
					if (chars.containsKey(cj)) {
						chars.clear();
						if (temp > max) {
							max = temp;
						}
						temp = 1;
						break;
					} else {
						chars.put(cj, 1);
						temp = temp + 1;
					}
				}
			}
			return max > temp ? max : temp;
		}
		return 0;
	}

}
