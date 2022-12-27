package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/
public class Combinations {

  private void select(int noOfEleToSelect, int start, int totalEle, List<Integer> combination, List<List<Integer>> combinationsList) {
    if(noOfEleToSelect == 0) {
      combinationsList.add(new ArrayList(combination));
      return;
    }
    for(int i = start; i <= (totalEle - noOfEleToSelect + 1); i++) {
      combination.add(i);
      select(noOfEleToSelect - 1, i + 1, totalEle, combination, combinationsList);
      combination.remove(combination.size() - 1);
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> combinationsList = new ArrayList();
    select(k, 1, n, new ArrayList(), combinationsList);
    return combinationsList;
  }

}
