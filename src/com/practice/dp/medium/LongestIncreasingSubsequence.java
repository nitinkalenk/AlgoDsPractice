package com.practice.dp.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

  private int max(int[] nums) {
    int max = 0;
    for(int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
    }
    return max;
  }

  public int lengthOfLIS1(int[] nums) {
    int[] dp = new int[nums.length];
    dp[nums.length - 1] = 1;
    for(int i = nums.length - 2; i >= 0; i--) {
      int maxLengthLis = 1;
      for(int j = i + 1; j < nums.length; j++) {
        if(nums[j] > nums[i]) {
          maxLengthLis = Math.max(maxLengthLis, 1 + dp[j]);
        }
      }
      dp[i] = maxLengthLis;
    }
    return max(dp);
  }

  public int lengthOfLIS(int[] nums) {
    List<Integer> temp = new ArrayList<>();
    temp.add(nums[0]);
    for(int i = 1; i < nums.length; i++) {
      if(nums[i] > temp.get(temp.size() - 1)) {
        temp.add(nums[i]);
      } else {
        int lb = 0, ub = temp.size() - 1;
        while(lb != ub) {
          int middle = (lb + ub) / 2;
          if (temp.get(middle) < nums[i])
            lb = middle + 1;
          else
            ub = middle;
        }
        temp.set(lb, nums[i]);
      }
    }
    return temp.size();
  }

}
