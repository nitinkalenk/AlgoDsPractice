package com.practice.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

/*  private List<Integer> list(int num1, int num2) {
    List<Integer> list = new ArrayList();
    list.add(num1);
    list.add(num2);
    return list;
  }

  private int[] array(List<Integer> list) {
    int[] arr = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      arr[i] = list.get(i);
    }
    return arr;
  }

  private int[][] toArray(List<List<Integer>> list) {
    int[][] array = new int[list.size()][];
    for (int i = 0; i < list.size(); i++) {
      array[i] = array(list.get(i));
    }
    return array;
  }

  public int[][] merge(int[][] intervals) {
    List<List<Integer>> ans = new ArrayList();

    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i][0] != -1 && intervals[i][1] != -1) {
        int[] currentInterval = intervals[i];
        int min = currentInterval[0];
        int max = currentInterval[1];

        for (int j = i + 1; j < intervals.length; j++) {
          if (intervals[j][0] != -1 && intervals[j][1] != -1) {
            if (intervals[j][0] >= min && intervals[j][1] <= max) {
              min = Math.min(min, intervals[j][0]);
              max = Math.max(max, intervals[j][1]);
            }
          }
          ans.add(list(min, max));
        }
      }
    }
    return toArray(ans);
  }*/

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    LinkedList<int[]> mergedList = new LinkedList();
    for(int[] currInterval : intervals) {
      if(mergedList.isEmpty() || mergedList.getLast()[1] < currInterval[0]) {
        mergedList.add(currInterval);
      } else {
        mergedList.getLast()[0] = Math.min(mergedList.getLast()[0], currInterval[0]);
        mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], currInterval[1]);
      }
    }

    return mergedList.toArray(new int[mergedList.size()][]);
  }

}
