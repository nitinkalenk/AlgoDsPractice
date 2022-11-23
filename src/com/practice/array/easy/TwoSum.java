package com.practice.array.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> noToIndexMap = new HashMap();
    for(int i = 0; i < nums.length; i++) {
      if(noToIndexMap.containsKey(target - nums[i])) {
        return new int[] {noToIndexMap.get(target - nums[i]), i};
      }
      noToIndexMap.put(nums[i], i);
    }
    return new int[]{};
  }

}
