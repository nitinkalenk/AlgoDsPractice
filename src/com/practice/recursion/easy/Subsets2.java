package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

  //https://leetcode.com/problems/subsets-ii/
  private void subsetsWithDup(int[] nums, int currentIndex, List<List<Integer>> subsets) {
    if(currentIndex == nums.length) {
      return;
    }
    int count = 0;
    while((currentIndex + count) < nums.length && nums[currentIndex] == nums[currentIndex + count]) {
      count++;
    }
    int size = subsets.size();
    for(int i = 0; i < size; i++) {
      List<Integer> newSubset = new ArrayList(subsets.get(i));
      for(int j = 0; j < count; j++) {
        newSubset.add(nums[currentIndex]);
        subsets.add(new ArrayList(newSubset));
      }
    }
    subsetsWithDup(nums, currentIndex + count, subsets);
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> subsets = new ArrayList();
    subsets.add(new ArrayList());
    Arrays.sort(nums);
    subsetsWithDup(nums, 0, subsets);
    return subsets;
  }

}
