package com.practice.utility;

import java.util.List;

public class Array {

  //
  public Integer[][] toIntegerArray(List<List<Integer>> list) {
    return list.stream()
        .map(l -> l.toArray(Integer[]::new))
        .toArray(Integer[][]::new);
  }
  //

  //
  public int[] toArray(List<Integer> list) {
    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  public int[][] toIntArray(List<List<Integer>> list) {
    int[][] arr = new int[list.size()][];
    for (int i = 0; i < list.size(); i++) {
      arr[i] = toArray(list.get(i));
    }
    return arr;
  }
  //

  public String[][] toStringArray(List<List<String>> list) {
    return list.stream()
        .map(l -> l.toArray(new String[0]))
        .toArray(String[][]::new);
  }

  private int[][] toArr(List<int[]> list) {
    return list.toArray(new int[0][]);
  }

}
