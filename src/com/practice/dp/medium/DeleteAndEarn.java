package com.practice.dp.medium;

public class DeleteAndEarn {

  //https://leetcode.com/problems/delete-and-earn/
  public int deleteAndEarn(int[] nums) {
    int[] values = new int[10001];
    int skip = 0;
    int take = 0;
    for (int num : nums)
      values[num] += num;
    for(int i = 0; i < values.length; i++) {
      int takei = skip + values[i];
      int skipi = Math.max(take, skip);
      skip = skipi;
      take = takei;
    }
    return Math.max(skip, take);
  }

}
