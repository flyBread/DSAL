package com.zlz.leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhailzh
 * 
 * @Date 201511139:04:21
 */
public class L3LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		L3LongestSubstringWithoutRepeatingCharacters chars = new L3LongestSubstringWithoutRepeatingCharacters();
		int value = chars.lengthOfLongestSubstring3_improve("abcabcbbpoiuytrewq");
		System.out.println(value);
		System.out.println(chars.lengthOfLongestSubstring("abcabcbbpoiuytrewq"));

		int value3 = chars.lengthOfLongestSubstring3_improve("abcabcbbpoe");
		System.out.println(value3);
		System.out.println(chars.lengthOfLongestSubstring("abcabcbbpoe"));

		int value4 = chars.lengthOfLongestSubstring3_improve("abcabcbbpo");
		System.out.println(value4);
		System.out.println(chars.lengthOfLongestSubstring("abcabcbbpo"));
		System.out.println(chars.lengthOfLongestSubstring3_normal("abcabcbbpo"));

		
	}

	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
	}

	/**
	 * 循环一遍，主要的原因是map的数据结构中存储的索引是位置。
	 * */
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

	//看看别人的代码是如何写的
	 public int lengthOfLongestSubstring3_normal(String s) {
		    int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	    }
	 
	//优化自己的代码
	 public int lengthOfLongestSubstring3_improve(String s) {
			char[] content = s.toCharArray();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			int max = 0, start = 0;
			for (int i = 0; i < content.length; i++) {
				char c = content[i];
				if(map.containsKey(c)){
					start = Math.max(map.get(c), start);
				}
				max = Math.max(max, i-start + 1);
	            map.put(c, i + 1);
			}
			return max ;
		}
	
	/**
	 * 两次循环
	 * */
	public int lengthOfLongestSubstring1(String s) {
		if (s != null && !s.isEmpty()) {
			char[] content = s.toCharArray();
			int temp = 1, max = 1;
			HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
			chars.put(content[0], 1);
			for (int i = 1; i < content.length; i++) {
				for (int j = i + 1; j < content.length; j++) {
					char cj = content[j];
					if (!chars.containsKey(cj)) {
						chars.put(cj, 1);
						temp = temp + 1;
					} else {
						chars.clear();
						if (temp > max) {
							max = temp;
						}
						temp = 1;
						break;
					}
				}
			}
			return max > temp ? max : temp;
		}
		return 0;
	}

}
