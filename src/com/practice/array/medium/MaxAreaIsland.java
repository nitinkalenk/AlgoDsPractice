package com.practice.array.medium;

//https://leetcode.com/problems/max-area-of-island
public class MaxAreaIsland {

  private int area(int i, int j, boolean[][] visited, int[][] grid) {
    if(i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || visited[i][j]==true || grid[i][j] == 0) {
      return 0;
    }
    visited[i][j] = true;
    return 1 + area(i, j-1, visited, grid) + area(i, j+1, visited, grid) + area(i+1, j, visited, grid) + area(i-1, j, visited, grid);
  }

  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int maxArea = 0;
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        maxArea = Math.max(maxArea, area(i, j, visited, grid));
      }
    }
    return maxArea;
  }

}
