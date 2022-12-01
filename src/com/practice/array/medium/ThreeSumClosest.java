package com.practice.array.medium;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int closestTarget = nums[0] + nums[1] + nums[2];
    for(int i = 0; i < nums.length - 2; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      while(j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        int currentGap = sum > target ? sum - target : target - sum;
        int colsestTargetGap = closestTarget > target ? closestTarget - target : target - closestTarget;
        closestTarget = currentGap < colsestTargetGap ? sum : closestTarget;
        if(sum > target) {
          k--;
        } else {
          j++;
        }
      }
    }

    return closestTarget;
  }

}
