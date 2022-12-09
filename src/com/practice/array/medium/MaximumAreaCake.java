package com.practice.array.medium;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts
public class MaximumAreaCake {

  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    int modulo = 1000000007;

    long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
    for(int i = 1; i < horizontalCuts.length; i++) {
      maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i-1]);
    }

    long maxLength = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
    for(int i = 1; i < verticalCuts.length; i++) {
      maxLength = Math.max(maxLength, verticalCuts[i] - verticalCuts[i - 1]);
    }

    return (int)(((maxLength % modulo) * (maxHeight % modulo)) % modulo) ;
  }

}
