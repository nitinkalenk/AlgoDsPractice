package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
public class CombiinationSum2 {

  private void combinationSum(int currentIndex, int currentSum, int target, int[] candidates, List<Integer> combination,
      List<List<Integer>> combinationList) {
    if (currentSum == target) {
      combinationList.add(new ArrayList(combination));
      return;
    }
    if (currentIndex >= candidates.length || currentSum > target) {
      return;
    }
    int count = 0;
    while ((currentIndex + count) < candidates.length && candidates[currentIndex] == candidates[currentIndex + count]) {
      count++;
    }
    combinationSum(currentIndex + count, currentSum, target, candidates, combination, combinationList);
    combination.add(candidates[currentIndex]);
    combinationSum(currentIndex + 1, currentSum + candidates[currentIndex], target, candidates, combination, combinationList);
    combination.remove(combination.size() - 1);
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> combinationList = new ArrayList();
    Arrays.sort(candidates);
    combinationSum(0, 0, target, candidates, new ArrayList(), combinationList);
    return combinationList;
  }

}
