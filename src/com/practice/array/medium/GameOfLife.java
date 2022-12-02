package com.practice.array.medium;

public class GameOfLife {

  class GameOfLifeV1 {
    private boolean isVisited(int i, int j, int k, int l) {
      return k < i || (k == i && l < j);
    }

    private int getVisitedCellValue(int i, int j, int[][] board) {
      return board[i][j] / 10;
    }

    private int getCellValue(int i, int j, int k, int l, int[][] board) {
      if(k < 0 || k >= board.length) {
        return 0;
      } else if(l < 0 || l >= board[0].length) {
        return 0;
      }
      return isVisited(i, j, k, l) ? getVisitedCellValue(k, l, board) : board[k][l];
    }

    private int getLiveCellsCount(int i,int j,int[][] board) {
      return getCellValue(i, j, i-1, j-1, board) + getCellValue(i , j, i-1, j, board) + getCellValue(i, j, i-1, j+1, board) +
          getCellValue(i, j, i, j-1, board) + getCellValue(i, j, i, j+1, board) +
          getCellValue(i, j, i+1, j-1, board) + getCellValue(i, j, i+1, j, board) + getCellValue(i, j, i+1, j+1, board);
    }

    public void gameOfLife(int[][] board) {
      for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[i].length; j++) {
          int liveCellsCount = getLiveCellsCount(i, j, board);
          int updatedValue = board[i][j];
          if(board[i][j] == 0) {
            updatedValue = liveCellsCount == 3 ? 2 : 0;
          } else {
            updatedValue = liveCellsCount >= 2 && liveCellsCount <= 3 ? 3 : 1;
          }
          board[i][j] = board[i][j] * 10 + updatedValue;
        }
      }


      for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[i].length; j++) {
          board[i][j] = board[i][j] % 10;
        }
      }
    }
  }

  class GameOfLifeV2 {
    private int getCellValue(int k, int l, int[][] board) {
      if(k < 0 || k >= board.length) {
        return 0;
      } else if(l < 0 || l >= board[0].length) {
        return 0;
      }
      return board[k][l] & 1;
    }

    private int getLiveCellsCount(int i,int j,int[][] board) {
      return getCellValue(i-1, j-1, board) + getCellValue(i-1, j, board) + getCellValue(i-1, j+1, board) +
          getCellValue(i, j-1, board) + getCellValue(i, j+1, board) +
          getCellValue(i+1, j-1, board) + getCellValue(i+1, j, board) + getCellValue(i+1, j+1, board);
    }

    public void gameOfLife(int[][] board) {
      for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[i].length; j++) {
          int liveCellsCount = getLiveCellsCount(i, j, board);
          int updatedValue = board[i][j];
          if(board[i][j] == 0) {
            updatedValue = liveCellsCount == 3 ? 2 : 0;
          } else {
            updatedValue = liveCellsCount >= 2 && liveCellsCount <= 3 ? 3 : 1;
          }
          board[i][j] = updatedValue;
        }
      }


      for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[i].length; j++) {
          board[i][j] = board[i][j] >> 1;
        }
      }
    }
  }
}
