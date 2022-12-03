package com.practice.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> quadraplets = new ArrayList();

    Arrays.sort(nums);

    for(int i = 0; i < nums.length - 3; i++) {
      for(int j = i + 1; j < nums.length - 2; j++) {
        int front = j + 1;
        int back = nums.length - 1;
        while(front < back) {
          long sum = (long)(nums[i] + (long)nums[j] + nums[front] + (long)nums[back]);
          if(sum < target) {
            front++;
          } else if(sum > target) {
            back--;
          } else {
            List<Integer> list = List.of(nums[i], nums[j], nums[front], nums[back]);
            quadraplets.add(list);

            while(front < back && nums[front] == list.get(2)) front++;
            while(front < back && nums[back] == list.get(3)) back--;
          }
        }
        while(j < nums.length - 2 && nums[j] == nums[j + 1]) j++;
      }
      while(i < nums.length - 3 && nums[i] == nums[i + 1]) i++;
    }

    return quadraplets;
  }


}
