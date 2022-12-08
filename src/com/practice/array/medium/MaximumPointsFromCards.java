package com.practice.array.medium;

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards
public class MaximumPointsFromCards {

  public int maxScore(int[] cardPoints, int k) {
    int maxSum = 0;
    for(int i = cardPoints.length - k; i < cardPoints.length; i++) {
      maxSum += cardPoints[i];
    }

    int j = cardPoints.length - k;
    int i = 0;
    int lastWindowSum = maxSum;
    while(j < cardPoints.length) {
      maxSum = Math.max((lastWindowSum - cardPoints[j]) + cardPoints[i], maxSum);
      lastWindowSum = (lastWindowSum - cardPoints[j]) + cardPoints[i];
      i++;
      j++;
    }
    return maxSum;
  }

}
