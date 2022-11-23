package com.practice.array;

public class RemoveDuplSortedArr {

  //https://leetcode.com/problems/remove-duplicates-from-sorted-array/
  public int removeDuplicates(int[] nums) {
    int currentEleIndex = 0;
    for(int i = 1; i < nums.length; i++) {
      if(nums[i] != nums[currentEleIndex]) {
        nums[++currentEleIndex] = nums[i];
      }
    }
    return currentEleIndex + 1;
  }

}
