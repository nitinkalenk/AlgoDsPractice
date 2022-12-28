package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

  //https://leetcode.com/problems/combination-sum/
  private void combinationSum(int currentIndex, int[] candidates, int currentSum, int target, List<Integer> combination, List<List<Integer>> combinationsList) {
    if(currentSum == target) {
      combinationsList.add(new ArrayList(combination));
      return;
    } else if(currentSum > target || currentIndex >= candidates.length) {
      return;
    }
    combinationSum(currentIndex + 1, candidates, currentSum, target, combination, combinationsList);
    combination.add(candidates[currentIndex]);
    combinationSum(currentIndex, candidates, currentSum + candidates[currentIndex], target, combination, combinationsList);
    combination.remove(combination.size() - 1);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> combinationsList = new ArrayList();
    combinationSum(0, candidates, 0, target, new ArrayList(), combinationsList);
    return combinationsList;
  }

}
