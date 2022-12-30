package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSum3 {

  private void combinationSum(int maxLength, int target, int currentNum, int currentSum, List<Integer> combination, List<List<Integer>> combinationList) {
    if(currentSum == target && combination.size() == maxLength) {
      combinationList.add(new ArrayList(combination));
      return;
    }
    if(combination.size() >= maxLength || currentSum > target || currentNum > 9) {
      return;
    }
    combinationSum(maxLength, target, currentNum + 1, currentSum, combination, combinationList);
    combination.add(currentNum);
    combinationSum(maxLength, target, currentNum + 1, currentSum + currentNum, combination, combinationList);
    combination.remove(combination.size() - 1);
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList();
    combinationSum(k, n, 1, 0, new ArrayList(), ans);
    return ans;
  }

}
