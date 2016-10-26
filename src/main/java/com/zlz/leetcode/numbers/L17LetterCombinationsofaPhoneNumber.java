package com.zlz.leetcode.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhailzh
 * 
 */
public class L17LetterCombinationsofaPhoneNumber {

  public static List<String> letterCombinations3(String digits) {
    List<String> result = new ArrayList<String>();
    if (digits.length() == 0) return result;
    result = letterCombination(0, digits);
    return result;
  }

  private static List<String> letterCombination(int start, String digits) {
    List<String> result = new ArrayList<String>();
    if (start == digits.length()) {
      result.add("");
      return result;
    }
    List<String> temp = letterCombination(start + 1, digits);
    int index = digits.charAt(start) - '0';
    for (String first : refer[index]) {
      for (String second : temp) {
        result.add(first + second);
      }
    }
    return result;
  }



  private List<String> getStrings(char i) {
    switch (i) {
    case '2':
      return Arrays.asList("a", "b", "c");
    case '3':
      return Arrays.asList("d", "e", "f");
    case '4':
      return Arrays.asList("g", "h", "i");
    case '5':
      return Arrays.asList("j", "k", "l");
    case '6':
      return Arrays.asList("m", "n", "o");
    case '7':
      return Arrays.asList("p", "q", "r", "s");
    case '8':
      return Arrays.asList("v", "t", "u");
    case '9':
      return Arrays.asList("w", "x", "y", "z");
    default:
      break;
    }
    return null;
  }

  /**
   *
   * 
   */

  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<String>();
    List<String> temp1 = new ArrayList<String>();
    if (digits == null || digits.isEmpty()) {
      return res;
    }
    List<List<String>> collections = new ArrayList<List<String>>();
    for (int i = 0; i < digits.length(); i++) {
      List<String> temp = getStrings(digits.charAt(i));
      if (temp != null) {
        collections.add(temp);
      }
    }
    forEach(res, collections, 0, temp1);
    return res;
  }

  private void forEach(List<String> res, List<List<String>> collections, int i,
      List<String> temp1) {
    if (i == 0) {
      temp1.addAll(collections.get(i));
      if (i + 1 == collections.size()) {
        res.addAll(temp1);
        return;
      }
      forEach(res, collections, i + 1, temp1);
    } else {
      List<String> temp = new ArrayList<String>();
      for (String element : temp1) {
        for (String add : collections.get(i)) {
          temp.add(element + add);
        }
      }

      if (i + 1 == collections.size()) {
        res.clear();
        res.addAll(temp);
        return;
      }
      forEach(res, collections, i + 1, temp);
    }
  }


    ///////////////////////////////////////////////////////////////////////////////////
  public static void main(String[] args) {
    L17LetterCombinationsofaPhoneNumber num = new L17LetterCombinationsofaPhoneNumber();
    System.out.println(num.letterCombinations1("234"));
  }

    private static String[][] refer = { {}, {}, { "a", "c", "b" }, { "d", "e", "f" }, { "g", "h",
            "i" }, { "j", "k", "l" }, { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w",
            "x", "y", "z" } };

    /**
     * 第一个念头，遍历几层的问题，我们遍历的输出即可
     */
    public List<String> letterCombinations1(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        for (int i = 0; i < digits.length(); i++) {
            int value = digits.charAt(i) - '0';
            if (value > 1) {
                if (res.isEmpty()) {
                    res.addAll(Arrays.asList(refer[value]));
                } else {
                    List<String> temp1 = new ArrayList<String>();
                    for (int j = 0; j < res.size(); j++) {
                        for (int j2 = 0; j2 < refer[value].length; j2++) {
                            String ele = res.get(j);
                            String add = refer[value][j2];
                            temp1.add(ele + add);
                        }
                    }
                    res = temp1;
                }
            }
        }
        return res;
    }
}
