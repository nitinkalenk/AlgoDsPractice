package com.practice.array.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array
public class FindAllDuplicatesArr {

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> duplicates = new ArrayList();
    for(int i = 0; i < nums.length; i++) {
      if(nums[Math.abs(nums[i]) - 1] < 0) {
        duplicates.add(Math.abs(nums[i]));
      } else {
        nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
      }
    }
    return duplicates;
  }

}
