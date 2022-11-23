package com.practice.array.easy;

public class MoveZeros {

  public void moveZeroes(int[] nums) {
    int currentNonZeroIndex = 0;
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] != 0) {
        nums[currentNonZeroIndex++] = nums[i];
      }
    }
    for(int i = currentNonZeroIndex; i < nums.length; i++) {
      nums[i] = 0;
    }
  }

}
