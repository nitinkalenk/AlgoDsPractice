package com.practice.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
    for(int i = 0; i < numRows; i++) {
      List<Integer> currentPascalRow = new ArrayList(Arrays.asList(new Integer[i + 1]));
      currentPascalRow.set(0, 1);
      currentPascalRow.set(i, 1);
      for(int j = 1; j < i; j++) {
        currentPascalRow.set(j, pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
      }
      pascalTriangle.add(currentPascalRow);
    }
    return pascalTriangle;
  }

  public static void main(String[] args) {
    generate(5);
  }

}
