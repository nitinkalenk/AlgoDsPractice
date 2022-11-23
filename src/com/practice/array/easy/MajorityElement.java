package com.practice.array.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/
public class MajorityElement {

  public int majorityElementV1(int[] nums) {
    Map<Integer, Integer> numToOccurenceMap = new HashMap();
    for(int num: nums) {
      int currentNumOccurences = numToOccurenceMap.containsKey(num) ? numToOccurenceMap.get(num) + 1 : 1;
      numToOccurenceMap.put(num, currentNumOccurences);
      if(currentNumOccurences > (nums.length / 2)) {
        return num;
      }
    }
    return -1;
  }

  public int majorityElementV2(int[] nums) {
    int majorityElement = 0;
    for(int i = 0; i < 32; i++) {
      int bit = 1 << i;
      int oneBitCount = 0;
      for(int num : nums) {
        if((num & bit) != 0) {
          oneBitCount++;
        }
      }
      if(oneBitCount > nums.length / 2) {
        majorityElement = majorityElement | bit;
      }
    }
    return majorityElement;
  }


  public int majorityElement(int[] nums) {
    int count = 0;
    int candidate = 0;
    for(int num : nums) {
      if(count == 0) {
        candidate = num;
      }
      count += (candidate == num) ? 1 : -1;
    }
    return candidate;
  }

}
