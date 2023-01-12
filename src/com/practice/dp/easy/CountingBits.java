package com.practice.dp.easy;

public class CountingBits {

  //https://leetcode.com/problems/counting-bits/
  public int[] countBits(int n) {
    int[] arr = new int[n + 1];
    arr[0] = 0;
    if(n == 0) {
      return arr;
    }
    arr[1] = 1;
    int num = 2;
    while(num <= n) {
      arr[num] = 1;
      num = num * 2;
    }
    int largestNumDivisibleByTwo = 2;
    for(int i = 3; i <= n; i++) {
      if(arr[i] == 1) {
        largestNumDivisibleByTwo = i;
      } else {
        arr[i] = 1 + arr[i - largestNumDivisibleByTwo];
      }
    }

    return arr;
  }

  public int[] countBitsV2(int n) {
    int[] arr = new int[n + 1];
    arr[0] = 0;
    for(int i = 1; i <= n; i++) {
      arr[i] = arr[i/2] + i%2;
    }

    return arr;
  }


}
