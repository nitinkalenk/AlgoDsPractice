package com.practice.dp.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

  public boolean wordBreak(String str, Set<String> wordDict, int currentIndex, int[] memArr) {
    if(currentIndex >= str.length()) {
      return true;
    } else if(memArr[currentIndex] != -1) {
      return memArr[currentIndex] == 1;
    } else {
      for(int i = currentIndex + 1; i <= str.length(); i++) {
        String subStr = str.substring(currentIndex, i);
        if(wordDict.contains(subStr) && wordBreak(str, wordDict, i, memArr)) {
          memArr[currentIndex] = 1;
          return true;
        }
      }
      memArr[currentIndex] = 0;
      return false;
    }
  }

  public boolean wordBreak(String str, List<String> wordDict) {
    int[] memArr = new int[str.length()];
    Arrays.fill(memArr, -1);
    return wordBreak(str, new HashSet(wordDict), 0, memArr);
  }

}
