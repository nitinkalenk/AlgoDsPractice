package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  private static void subsets(int[] nums, List<List<Integer>> ans, int currentIndex) {
    if(currentIndex >= nums.length) {
      return;
    }
    int ansLength = ans.size();
    for(int i = 0; i < ansLength; i++) {
      List<Integer> newSubset = new ArrayList(ans.get(i));
      newSubset.add(nums[currentIndex]);
      ans.add(newSubset);
    }
    subsets(nums, ans, currentIndex + 1);
  }

  //https://leetcode.com/problems/subsets/
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList();
    ans.add(new ArrayList());
    subsets(nums, ans, 0);
    return ans;
  }

}
