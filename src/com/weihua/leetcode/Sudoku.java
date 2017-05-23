package com.weihua.leetcode;

import java.util.HashSet;

public class Sudoku {
    public static final int BOARD_SIZE = 9;
    public static void main(String[] args) {
        Sudoku tester = new Sudoku();
        char[][] board = {}; 
//        tester.isValidSudoku(board);
        
        char[][] board2 = {{}}; 
//        tester.isValidSudoku(board2);
        
        char[][] board3 = {{'.', '8', '7','6','5','4','3','2','1'}, 
                        {'2', '.', '8', '.', '.', '.', '.', '.', '.'}, 
                        {'3', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                        {'4', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                        {'5', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                        {'6', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                        {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                        {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                        {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
//        System.out.println(tester.isValidSudoku(board3));
        
        char[][] board4 = {{'.', '.', '5', '7', '.', '.', '.','.','6'},
                        {'.','.','.', '.', '1', '7', '.','.','.'},
                        {'.','.','.','.','.','.','.','.','.',},
                        {'.','.','.','.','.','9', '2', '.','.'},
                        {'5', '.','.','.','.','2','.','.','.'},
                        {'.','.','.','.','.','.','.','3','.'},
                        {'.','.','.','5','4','.','.','.','.'},
                        {'3', '.','.','.','.','.','4','2','.'},
                        {'.','.','.','2','7','.','6','.','.'}
                        };
        System.out.println(tester.isValidSudoku(board4));
    }
    
    public boolean isValidSudoku(char[][] board) {
        if (board.length != BOARD_SIZE || board[0].length != BOARD_SIZE) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> numbers = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!isValidNumber(board[i][j]) || numbers.contains(board[i][j])) {
                    return false;
                }
                numbers.add(board[i][j]);
            }
        }
        
        for (int i = 0; i < board[0].length; i++) {
            HashSet<Character> numbers = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (!isValidNumber(board[j][i]) || numbers.contains(board[j][i])) {
                    return false;
                }
                numbers.add(board[j][i]);
            }
        }
        
        for (int iBase = 0; iBase < BOARD_SIZE; iBase += 3) {
            for (int jBase = 0; jBase < BOARD_SIZE; jBase +=3) {
                HashSet<Character> numbers = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i+iBase][j+jBase] == '.') {
                            continue;
                        }
                        if (!isValidNumber(board[i+iBase][j+jBase]) || numbers.contains(board[i+iBase][j+jBase])) {
                            return false;
                        }
                        numbers.add(board[i+iBase][j+jBase]);
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean isValidNumber(char input) {
        "abc".length();
        return input >= '1' && input <= '9';
    }
}
