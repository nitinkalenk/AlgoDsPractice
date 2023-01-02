package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class PhoneNoLetterCombs {

  private final String[] arr = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  private void letterCombinations(int currentIndex, String currentCombination, String digits, List<String> result) {
    if(currentCombination.length() == digits.length()) {
      result.add(currentCombination);
      return;
    }
    int currentNumber = Character.getNumericValue(digits.charAt(currentIndex));
    String chars = arr[currentNumber - 1];
    for(int i = 0; i < chars.length(); i++) {
      letterCombinations(currentIndex+1, currentCombination + chars.charAt(i), digits, result);
    }
  }

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList();
    if(digits.length() == 0) {
      return result;
    }
    letterCombinations(0, "", digits, result);
    return result;
  }

}
