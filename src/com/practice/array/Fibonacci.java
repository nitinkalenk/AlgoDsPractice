package com.practice.array;

public class Fibonacci {

  //https://leetcode.com/problems/fibonacci-number/
  public int fib(int n) {
    int n1 = 0;
    int n2 = 1;
    if(n == 0) {
      return n1;
    } else if(n == 1) {
      return n2;
    } else {
      int fib = 0;
      n = n - 2;
      while(n-- >= 0) {
        fib = n1 + n2;
        n1 = n2;
        n2 = fib;
      }
      return fib;
    }
  }

}
