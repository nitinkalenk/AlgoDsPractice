package com.practice.array.medium;


// https://leetcode.com/problems/jump-game-ii/
public class JumpGame2 {

  public int jump(int[] nums) {
    int jumps = 0, currentFarthest = 0, currEnd = 0;
    for(int i = 0; i < nums.length; i++) {
      currentFarthest = Math.max(currentFarthest, i + nums[i]);
      if(i == currEnd) {
        jumps++;
        currEnd = currentFarthest;
      }
    }
    return jumps;
  }

}
