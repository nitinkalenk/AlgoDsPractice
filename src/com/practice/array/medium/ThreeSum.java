package com.practice.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> tripletsList = new ArrayList();

    Arrays.sort(nums);

    for(int i = 0; i <= nums.length -3; i++) {
      int front = i + 1;
      int back = nums.length - 1;
      int target = -nums[i];

      while(front < back) {
        int sum = nums[front] + nums[back];
        if(sum < target) {
          front++;
        } else if(sum > target) {
          back--;
        } else {
          List<Integer> triplet= List.of(nums[i], nums[front], nums[back]);
          tripletsList.add(triplet);
          while(front < back && nums[front] == triplet.get(1))  front++;
          while(front < back && nums[back] == triplet.get(2))  back--;
        }
      }
      while(i <= nums.length -3 && nums[i] == nums[i+1]) i++;

    }

    return tripletsList;
  }


}
