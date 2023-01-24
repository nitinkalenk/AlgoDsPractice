package com.practice.dp.easy;

import java.util.Arrays;

public class DecodeWays {

  private int numDecodings(String str, int currentIndex, int[] memArr) {
    if(currentIndex >= str.length()) {
      return 1;
    } else if(memArr[currentIndex] != -1) {
      return memArr[currentIndex];
    } else if(str.charAt(currentIndex) == '0') {
      return 0;
    } else {
      int oneLengthPossibleWays = numDecodings(str, currentIndex + 1, memArr);
      int twoLengthPossibleWays = 0;
      if(currentIndex + 2 <= str.length() && Integer.parseInt(str.substring(currentIndex, currentIndex + 2)) <= 26) {
        twoLengthPossibleWays = numDecodings(str, currentIndex + 2, memArr);
      }
      memArr[currentIndex] = oneLengthPossibleWays + twoLengthPossibleWays;
      return memArr[currentIndex];
    }
  }

  public int numDecodings(String str) {
    int[] memArr = new int[str.length()];
    Arrays.fill(memArr, -1);
    return numDecodings(str, 0, memArr);
  }

}
