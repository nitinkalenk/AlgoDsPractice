package com.practice.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

  private void markQueensPlaces(int i, int j, char[][] board) {
    int iIndex = i;
    int jIndex = j;
    while(++iIndex < board.length) {
      if(board[iIndex][jIndex] == '\u0000') {
        board[iIndex][jIndex] = '.';
      }
    }
    iIndex = i;
    jIndex = j;
    while(--iIndex >= 0) {
      if(board[iIndex][jIndex] == '\u0000') {
        board[iIndex][jIndex] = '.';
      }
    }

    iIndex = i;
    jIndex = j;
    while(++jIndex < board[0].length) {
      if(board[iIndex][jIndex] == '\u0000') {
        board[iIndex][jIndex] = '.';
      }
    }

    iIndex = i;
    jIndex = j;
    while(--jIndex >= 0) {
      if(board[iIndex][jIndex] == '\u0000') {
        board[iIndex][jIndex] = '.';
      }
    }

    iIndex = i;
    jIndex = j;
    while(++iIndex < board.length && ++jIndex < board[0].length) {
      if(board[iIndex][jIndex] == '\u0000') {
        board[iIndex][jIndex] = '.';
      }
    }

    iIndex = i;
    jIndex = j;
    while(--iIndex >= 0 && --jIndex >= 0) {
      if(board[iIndex][jIndex] == '\u0000') {
        board[iIndex][jIndex] = '.';
      }
    }

    iIndex = i;
    jIndex = j;
    while(++iIndex < board.length && --jIndex >= 0) {
      if(board[iIndex][jIndex] == '\u0000') {
        board[iIndex][jIndex] = '.';
      }
    }

    iIndex = i;
    jIndex = j;
    while(--iIndex >= 0 && ++jIndex < board[0].length) {
      if(board[iIndex][jIndex] == '\u0000') {
        board[iIndex][jIndex] = '.';
      }
    }

  }

  private List<String> toList(char[][] board) {
    List<String> list = new ArrayList();
    for(int i = 0; i < board.length; i++) {
      list.add(new String(board[i]));
    }
    return list;
  }

  private void placeQueen(int i, int j, int remainingQueens, char[][] board, List<List<String>> result) {
    if(remainingQueens == 0) {
      result.add(toList(board));
      return;
    }
    if(j >= board[0].length) {
      placeQueen(i + 1, 0, remainingQueens, board, result);
      return;
    }
    if(i < 0 || i >= board.length || j < 0) {
      return;
    }
    if(board[i][j] == '.') {
      placeQueen(i, j + 1, remainingQueens, board, result);
    } else if(board[i][j] == '\u0000') {
      board[i][j] = 'Q';
      markQueensPlaces(i, j, board);
      placeQueen(i, j + 1, remainingQueens - 1, board, result);
    }
  }

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList();
    for(int i = 0; i < n; i++) {
      placeQueen(0, i, n, new char[n][n], result);
    }
    return result;
  }

  public static void main(String[] args) {
    //System.out.println(solveNQueens(4));
  }

}
