package com.practice.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

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
