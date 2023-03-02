package com.practice.dp.medium;

import java.util.Map;

public class KnightDialer {

  public static final int max = (int) Math.pow(10, 9) + 7;

  public static int knightDialer(int n) {
    int[][] dp = new int[10][n+1];
    Map<Integer, int[]> numToNextJumpsMap = Map.of(0, new int[]{4, 6}, 1, new int[]{6, 8}, 2, new int[]{7, 9}, 3, new int[]{4, 8},
        4, new int[]{0, 3, 9}, 5, new int[]{}, 6, new int[]{0, 1, 7}, 7, new int[]{2, 6},
        8, new int[]{1, 3}, 9, new int[]{2, 4});
    for(int i = 0; i < dp.length; i++) {
      dp[i][1] = 1;
    }
    for (int j = 2; j < dp[0].length; j++) {
      for(int i = 0; i < dp.length; i++) {
        int[] possibleNumbers = numToNextJumpsMap.get(i);
        int count = 0;
        for(int k = 0; k < possibleNumbers.length; k++) {
          count = (count + dp[possibleNumbers[k]][j-1]) % 1000000007;
        }
        dp[i][j] = count;
      }
    }
    int ans = 0;
    for(int i = 0; i < dp.length; i++) {
      ans = (ans + (dp[i][n])) % 1000000007;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(knightDialer(3131));
  }

}
