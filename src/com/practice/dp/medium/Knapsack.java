package com.practice.dp.medium;

public class Knapsack {

  static int knapSack(int capacity, int weights[], int values[], int noOfArtifacts)
  {
    int[][] memoArr = new int[noOfArtifacts + 1][capacity + 1];
    for(int i = 1; i < memoArr.length; i++) {
      for(int j = 1; j < memoArr[i].length; j++) {
        if(j - weights[i - 1] < 0) {
          memoArr[i][j] = memoArr[i-1][j];
        } else {
          memoArr[i][j] = Math.max(memoArr[i-1][j], memoArr[i-1][j - weights[i-1]] + values[i-1]);
        }
      }
    }
    return memoArr[noOfArtifacts][capacity];
  }

}
