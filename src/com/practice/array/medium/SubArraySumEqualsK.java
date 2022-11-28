package com.practice.array.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> sumToOccurenceMap = new HashMap();
    sumToOccurenceMap.put(0, 1);

    int noOfSubArrays = 0;
    int sum = 0;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if(sumToOccurenceMap.containsKey(sum - k)) {
        noOfSubArrays += sumToOccurenceMap.get(sum - k);
      }
      sumToOccurenceMap.put(sum, sumToOccurenceMap.getOrDefault(sum, 0) + 1);
      nums[i] = sum;
    }
    return noOfSubArrays;
  }

}
