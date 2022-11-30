package com.practice.array.medium;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

  private List<Integer> find(char ch, char[][] board) {
    List<Integer> indexes = new ArrayList();
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        if(board[i][j] == ch) {
          indexes.add(i);
          indexes.add(j);
        }
      }
    }
    return indexes;
  }

  private boolean charExists(char ch, int i, int j, char[][] board) {
    if(i < 0 || i >= board.length) {
      return false;
    } else if(j < 0 || j >= board[0].length) {
      return false;
    }
    return board[i][j] == ch;
  }

  private boolean wordExists(int currentIndex, String word, char[][] board, int i, int j) {
    if(currentIndex == word.length()) {
      return true;
    }else if(i < 0 || i >= board.length) {
      return false;
    } else if(j < 0 || j >= board[0].length) {
      return false;
    } else if(board[i][j] != word.charAt(currentIndex)) {
      return false;
    } else {
      board[i][j] ^= 256;
      boolean exist = wordExists(currentIndex+1, word, board, i + 1, j) ||
          wordExists(currentIndex+1, word, board, i - 1, j) ||
          wordExists(currentIndex+1, word, board, i, j + 1) ||
          wordExists(currentIndex+1, word, board, i, j -1);
      board[i][j] ^= 256;
      return exist;
    }
  }

  public boolean exist(char[][] board, String word) {
    List<Integer> indexes = find(word.charAt(0), board);
    for(int i = 0; i < indexes.size(); i=i+2) {
      if(wordExists(0, word, board, indexes.get(i), indexes.get(i + 1))) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    char[][] board = new char[][]{new char[]{'C','A','A'},
                                  new char[]{'A','A','A'},
                                  new char[]{'B','C','D'}
                                  };
    System.out.println((int)board[0][1]);
    board[0][1] ^= 70;
    System.out.println((int)board[0][1]);
    System.out.println(board[0][1]);
    board[0][1] ^= 70;
    System.out.println(board[0][1]);
  }

}
