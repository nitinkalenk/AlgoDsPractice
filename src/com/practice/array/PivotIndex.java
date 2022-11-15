package com.practice.array;

public class PivotIndex {

  private int sum(int[] nums) {
    int sum = 0;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    return sum;
  }

  public int pivotIndex(int[] nums) {
    int leftSum = 0;
    int rightSum = sum(nums);
    for(int i = 0; i < nums.length; i++) {
      rightSum -= nums[i];
      if(leftSum == rightSum) {
        return i;
      }
      leftSum += nums[i];
    }
    return -1;
  }

}
