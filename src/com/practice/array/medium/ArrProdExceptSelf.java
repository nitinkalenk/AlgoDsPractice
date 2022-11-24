package com.practice.array.medium;

import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self
public class ArrProdExceptSelf {

  public int[] productExceptSelfV1(int[] nums) {
    int[] prefixMulArray = new int[nums.length + 1];
    int[] suffixMulArray = new int[nums.length + 1];

    Arrays.fill(prefixMulArray, 1);
    Arrays.fill(suffixMulArray, 1);

    for(int i = 0; i < nums.length; i++) {
      prefixMulArray[i+1] = prefixMulArray[i] * nums[i];
    }
    for(int i = nums.length -1; i >= 0; i--) {
      suffixMulArray[i] = suffixMulArray[i+1] * nums[i];
    }

    int[] prodsArr = new int[nums.length];
    for(int i = 0; i < prodsArr.length; i++) {
      prodsArr[i] = prefixMulArray[i] * suffixMulArray[i+1];
    }

    return prodsArr;
  }

  public int[] productExceptSelfV2(int[] nums) {
    int[] lefts = new int[nums.length];
    int[] rights = new int[nums.length];

    for(int i = 0; i < lefts.length; i++) {
      if(i == 0) {
        lefts[i] = 1;
      } else {
        lefts[i] = lefts[i - 1] * nums[i - 1];
      }
    }

    for(int i = rights.length - 1; i >= 0; i--) {
      if(i == rights.length - 1) {
        rights[i] = 1;
      } else {
        rights[i] = rights[i + 1] * nums[i + 1];
      }
    }

    int[] prodsArr = new int[nums.length];
    for(int i = 0; i < prodsArr.length; i++) {
      prodsArr[i] = lefts[i] * rights[i];
    }
    return prodsArr;
  }

  public int[] productExceptSelf(int[] nums) {
    int[] lefts = new int[nums.length];

    for(int i = 0; i < lefts.length; i++) {
      if(i == 0) {
        lefts[i] = 1;
      } else {
        lefts[i] = lefts[i - 1] * nums[i - 1];
      }
    }

    int right = 1;
    for(int i = lefts.length - 1; i >= 0; i--) {
      lefts[i] = lefts[i] * right;
      right = right * nums[i];
    }

    return lefts;
  }

}
