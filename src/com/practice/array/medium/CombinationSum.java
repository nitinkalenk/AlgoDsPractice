package com.practice.array.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {

  private void backtrack(int currentNumIndex, List<Integer> currentNumbersList, int currentSum, int[] candidates, List<List<Integer>> ans, int target) {
    if(currentSum > target) {
      return;
    } else if(currentSum == target) {
      ans.add(new ArrayList(currentNumbersList));
      return;
    } else {
      for(int i = currentNumIndex; i < candidates.length; i++) {
        currentNumbersList.add(candidates[i]);
        backtrack(i, currentNumbersList, currentSum + candidates[i], candidates, ans, target);
        currentNumbersList.remove(currentNumbersList.size() - 1);
      }
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList();
    backtrack(0, new ArrayList(), 0, candidates, ans, target);
    return ans;
  }

}
