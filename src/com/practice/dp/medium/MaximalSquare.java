package com.practice.dp.medium;

public class MaximalSquare {

  //https://leetcode.com/problems/maximal-square/
  public int maximalSquare(char[][] matrix) {
    int[][] memo = new int[matrix.length + 1][matrix[0].length + 1];
    int maxSquare = 0;
    for(int i = 1; i < memo.length; i++) {
      for(int j = 1; j < memo[i].length; j++) {
        if(matrix[i-1][j-1] == '1') {
          memo[i][j] = 1 + Math.min(Math.min(memo[i][j-1], memo[i-1][j]), memo[i -1][j-1]);
          maxSquare = Math.max(memo[i][j], maxSquare);
        }
      }
    }
    return maxSquare * maxSquare;
  }

}
