package com.algprithm.letcode;

import java.util.HashMap;

/**
 * @author zhailzh
 * 
 * @Date 2015��11��13�ա�������9:04:21
 * 
 *       ���û���ظ����ַ��� . Given a string, find the length of the longest substring
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
			//���Ƕ������ʼ�Ĵ����о����������start ��ʼ��1���о��ȽϵĺϺ��߼�������
			//���� occ[ch] = i+1,�ͱȽϵ������,ֻ�ܹ����Ϊ��һ��Ԫ�ص�λ�û��ߣ���ʼ��λ��
			occ[ch] = i + 1;
			++counter;

		}

		return Math.max(max, counter);
	}

	// ���ö�̬�滮�ķ����������Ҫ�úõ���һ�밡
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

	// ������ݵı����ķ���
	public int lengthOfLongestSubstring2(String s) {
		if (s != null && !s.isEmpty()) {
			char[] content = s.toCharArray();
			HashMap<Character, Integer> charindex = new HashMap<Character, Integer>();
			int temp = 0, max = 0;
			int start = 0;
			for (int i = 0; i < content.length; i++) {
				char c = content[i];
				// ��ʼ��λ����i��������λ������֮��ȵ���һ��λ��j
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
						// ������ʱ�򣬿�ʼ���ַ�����ȵ�,���������ַ���λ��
						int ak = charindex.get(cj);
						// j Ϊ�����ַ���λ�ã�Ϊ�˲��û��ݣ�ֱ�Ӱ�i��Ϊj,Ȼ������temp��ֵ
						// a1,a2,...,ai,ai+1,...,ak,ak+1,....aj,aj+1
						// ���ʱ��ai��aj�ľ���Ϊtemp��
						// ��i��Ϊj֮��temp���ٵľ���Ϊ��ai �� ak-1 ֮���Ԫ�� k-i ���ԣ�
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

	// ����ƥ��ķ���
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
