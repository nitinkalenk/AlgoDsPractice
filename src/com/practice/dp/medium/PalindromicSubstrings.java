package com.practice.dp.medium;

public class PalindromicSubstrings {

  //https://leetcode.com/problems/palindromic-substrings/
  public int countSubstrings(String str) {
    int count = 0;
    for(int i = 0; i < str.length(); i++) {
      count += countSubstrings(i, i, str);
      count += countSubstrings(i, i + 1, str);
    }
    return count;
  }

  private int countSubstrings(int left, int right, String str) {
    int count = 0;
    while(left <= right && left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
      count++;
      left--;
      right++;
    }
    return count;
  }


}
