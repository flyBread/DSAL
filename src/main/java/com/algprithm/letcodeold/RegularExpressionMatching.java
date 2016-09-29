package com.algprithm.letcodeold;

/**
 * @author zhailzh
 * 
 * @Date 20151284:11:06
 * 
 */
public class RegularExpressionMatching {

	// Implement regular expression matching with support for '.' and '*'.
	//
	// '.' Matches any single character.
	// '*' Matches zero or more of the preceding element.
	//
	// The matching should cover the entire input string (not partial).
	//
	// The function prototype should be:
	// bool isMatch(const char *s, const char *p)
	//
	// Some examples:
	// isMatch("aa","a")  false
	// isMatch("aa","aa")  true
	// isMatch("aaa","aa")  false
	// isMatch("aa", "a*")  true
	// isMatch("aa", ".*")  true
	// isMatch("ab", ".*")  true
	// isMatch("aab", "c*a*b")  true

	public boolean isMatch(String s, String p) {
		if (s == null && p == null)
			return true;
		if (s == null || p == null)
			return false;
		return isMatch(s, 0, p, 0);
	}

	/**
	 * 递归实现
	 * */
	public boolean isMatch(String s, int sstart, String p, int pstart) {
		if (s.length() == sstart && p.length() == pstart)
			return true;
		if (p.length() == pstart)
			return false;
		if (s.length() == sstart) {
			if (pstart + 1 >= p.length() || p.charAt(pstart + 1) != '*') {
				return false;
			}
			return isMatch(s, sstart, p, pstart + 2);
		}

		if (pstart + 1 <= p.length() - 1 && p.charAt(pstart + 1) == '*') {
			if (s.charAt(sstart) == p.charAt(pstart) || p.charAt(pstart) == '.') {
				return isMatch(s, sstart + 1, p, pstart) || isMatch(s, sstart, p, pstart + 2);
			}
			return isMatch(s, sstart, p, pstart + 2);
		} else if (p.charAt(pstart) == '.') {
			return isMatch(s, sstart + 1, p, pstart + 1);
		} else {
			return p.charAt(pstart) == s.charAt(sstart) && isMatch(s, sstart + 1, p, pstart + 1);
		}
	}

	public static void main(String[] args) {
		RegularExpressionMatching na = new RegularExpressionMatching();
		System.out.println(na.isMatch("aaa", "aaaa"));
		boolean result = na.isMatch("asdaab", "c*a*b") == na.isMatch("asdaab", 0, "c*a*b", 0);
		System.out.println(result);

		boolean result2 = na.isMatch("a", "c") == na.isMatch("a", 0, "c", 0);
		System.out.println(result2);

		boolean result1 = na.isMatch("a", "a*");
		na.isMatch("aaa", 0, "aaa*", 0);
		System.out.println(result1);

		na.isMatch("aa", "a");
		na.isMatch("aa", "aa");

		na.isMatch("aa", "a*");
		na.isMatch("aa", ".*");
		na.isMatch("ab", ".*");
		na.isMatch("aab", "c*a*b");
	}

}
