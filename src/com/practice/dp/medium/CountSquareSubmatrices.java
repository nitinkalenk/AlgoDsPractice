package com.practice.dp.medium;

import java.util.Arrays;

public class CountSquareSubmatrices {

  public static int countSquares(int[][] matrix) {
    int[][] dp = new int[2][matrix[0].length + 1];
    int sum = 0;
    for(int i = 1; i <= matrix.length; i++) {
      System.out.println("----------");
      for(int j = 1; j <= matrix[0].length; j++) {
        if(matrix[i-1][j-1] != 0) {
          dp[i & 1][j] = matrix[i-1][j-1] + Math.min(dp[(i-1) & 1][j-1], Math.min(dp[(i-1) & 1][j], dp[i & 1][j-1]));
          sum += dp[i & 1][j];
        } else {
          dp[i & 1][j] = 0;
        }
      }
    }
    return sum;
  }

}
