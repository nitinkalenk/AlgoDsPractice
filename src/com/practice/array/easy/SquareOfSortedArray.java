package com.practice.array.easy;

public class SquareOfSortedArray {

  // https://leetcode.com/problems/squares-of-a-sorted-array
  private int firstNonNegativeIndex(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] >= 0) {
        return i;
      }
    }
    return nums.length;
  }

  public int[] sortedSquares(int[] nums) {
    int i = 0, j = nums.length - 1;
    int[] squaredArray = new int[nums.length];

    for(int k = squaredArray.length - 1; k >= 0; k--) {
      if(Math.abs(nums[i]) > Math.abs(nums[j])) {
        squaredArray[k] = nums[i] * nums[i];
        i++;
      } else {
        squaredArray[k] = nums[j] * nums[j];
        j--;
      }
    }

    return squaredArray;
  }

  public int[] sortedSquaresV1(int[] nums) {
    int i = firstNonNegativeIndex(nums);
    int j = i - 1;

    int[] squaredArray = new int[nums.length];
    int squareArrayCurrentIndex = 0;

    while(j >= 0 || i < nums.length) {
      if(j >= 0 && i < nums.length) {
        if((nums[i] * nums[i]) < (nums[j] * nums[j])) {
          squaredArray[squareArrayCurrentIndex++] = nums[i] * nums[i];
          i++;
        } else {
          squaredArray[squareArrayCurrentIndex++] = nums[j] * nums[j];
          j--;
        }
      } else if(j >= 0) {
        squaredArray[squareArrayCurrentIndex++] = nums[j] * nums[j];
        j--;
      } else {
        squaredArray[squareArrayCurrentIndex++] = nums[i] * nums[i];
        i++;
      }
    }
    return squaredArray;
  }

}
