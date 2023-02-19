package com.practice.dp.medium;

public class HouseRobber {

  public int rob(int[] nums) {
    int skip = 0;
    int take = 0;
    for(int i = 0; i < nums.length; i++) {
      int takei = skip + nums[i];
      int skipi = Math.max(skip, take);
      skip = skipi;
      take = takei;
    }
    return Math.max(skip, take);
  }

}
