package com.practice.array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  private void spiralOrder(int i1, int j1, int i2, int j2, List<Integer> list, int[][] matrix) {
    while(i1 <= i2 && j1 <= j2) {
      for(int j = j1; j <= j2; j++) {
        list.add(matrix[i1][j]);
      }
      i1++;

      for(int i = i1; i <= i2; i++) {
        list.add(matrix[i][j2]);
      }
      j2--;

      if(i1 <= i2) {
        for(int j = j2; j >= j1; j--) {
          list.add(matrix[i2][j]);
        }
        i2--;
      }

      if(j1 <= j2) {
        for(int i = i2; i >= i1; i--) {
          list.add(matrix[i][j1]);
        }
        j1++;
      }
    }

  }

  public List<Integer> spiralOrder(int[][] matrix) {
    int i1 = 0, j1 = 0, i2 = matrix.length - 1, j2 = matrix[0].length - 1 ;
    List<Integer> list = new ArrayList();

    spiralOrder(i1, j1, i2, j2, list, matrix);

    return list;
  }

}
