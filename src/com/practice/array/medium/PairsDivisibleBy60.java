package com.practice.array.medium;

//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
public class PairsDivisibleBy60 {

  public int numPairsDivisibleBy60(int[] time) {
    int pairsCount = 0;

    int[] remTimeOccurenceArr = new int[60];
    for (int i = 0; i < time.length; i++) {
      pairsCount += remTimeOccurenceArr[(60 - (time[i] % 60)) % 60];
      remTimeOccurenceArr[time[i] % 60] += 1;
    }

    return pairsCount;
  }

}
