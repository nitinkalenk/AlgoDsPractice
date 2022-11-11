package com.practice.array;

public class BestTimeStock2 {

  public int maxProfitV1(int[] prices) {
    int profit = 0;
    for(int i = 1; i < prices.length; i++) {
      if(prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }
    return profit;
  }

  public int maxProfit(int[] prices) {
    int profit = 0;
    for(int i = 1; i < prices.length; i++) {
      profit += Math.max(prices[i] - prices[i - 1], 0);
    }
    return profit;
  }

}
