package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Permutations2 {

  //https://leetcode.com/problems/permutations-ii/
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void permute(int[] nums, int currentPosition, List<List<Integer>> ans) {
    if(currentPosition == nums.length - 1) {
      ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
      return;
    }
    Set<Integer> appeared = new HashSet<>();
    for(int i = currentPosition; i < nums.length; i++) {
      if(appeared.add(nums[i])) {
        swap(nums, i, currentPosition);
        permute(nums, currentPosition + 1, ans);
        swap(nums, currentPosition, i);
      }
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList();
    Arrays.sort(nums);
    permute(nums, 0, ans);
    return ans;
  }


}
