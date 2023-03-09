package com.practice.dp.medium;

public class RangeSumQuery {
  private int[][] dp;

  public RangeSumQuery(int[][] matrix) {
    dp = new int[matrix.length + 1][matrix[0].length + 1];
    fillDpArray(dp, matrix);
  }

  private void fillDpArray(int[][] dp, int[][] matrix) {
    for(int i = 1; i < dp.length; i++) {
      for(int j = 1; j < dp[i].length; j++) {
        dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + matrix[i-1][j-1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];
  }


}
