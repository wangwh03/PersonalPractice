package com.weihua.leetcode;

import java.util.HashSet;

// Give an 2-day array of chars, and a word, find if a word exists.
// See default package for another harder interview question with honeycomb instead of matrix/2d-array
// BFS, check if there is a path starting from each point.  Remember to check if char is already used in current search path
public class WordSeacher {

    public static void main(String[] args) {
        WordSeacher wordSeacher = new WordSeacher();
//        char[][] test1 = null;
//        System.out.println(wordSeacher.exist(test1, "a"));
//        
//        char[][] test2 = {};
//        System.out.println(wordSeacher.exist(test2, "a"));
//
//        char[][] test3 = {{}};
//        System.out.println(wordSeacher.exist(test3, "a"));
//
//        char[][] test4 = {{'a'}};
//        System.out.println(wordSeacher.exist(test4, "a"));
//
//        char[][] test5 = {{'a'}};
//        System.out.println(wordSeacher.exist(test5, ""));
//        
//        char[][] test6 = {{'a'}};
//        System.out.println(wordSeacher.exist(test6, "abc"));
//
//        char[][] test7 = {{'a'}, {'b'}, {'c'}};
//        System.out.println(wordSeacher.exist(test7, "abc"));
//
//        char[][] test8 = {{'a', 'b', 'c'}};
//        System.out.println(wordSeacher.exist(test8, "abcba"));
//        
//        char[][] test9 = {{'a', 'b', 'c', 'e'},
//                        {'s', 'f', 'c', 's'},
//                        {'a', 'd', 'e', 'e'}};
//        System.out.println(wordSeacher.exist(test9, "abcced"));
//        System.out.println(wordSeacher.exist(test9, "see"));
//        System.out.println(wordSeacher.exist(test9, "abcb"));
        
//        char[][] test10 = {{'a', 'b', 'c', 'e'},
//                        {'s', 'f', 'e', 's'},
//                        {'a', 'd', 'e', 'e'}};
//        System.out.println(wordSeacher.exist(test10, "abceseeefs")); // wrong answer
        
        char[][] test10 = {{'c', 'e'},
                        {'e', 's'},
                        {'e', 'e'}};
        System.out.println(wordSeacher.exist(test10, "ceseee")); // wrong answer
    }
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(exist(board, word, 0, i, j, new HashSet<String>())) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean exist(char[][] board, String word, int wordIndex, int i, int j, HashSet<String> solutionChars) {
        if (wordIndex == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        
        if (solutionChars.contains(generateKey(i, j))) {
            return false;
        }
        
        if (board[i][j] != word.charAt(wordIndex)) {
            return false;
        }
        
        solutionChars.add(generateKey(i, j));
        boolean subResult = exist(board, word, wordIndex+1, i+1, j, solutionChars);
        if (subResult) {
            solutionChars.add(generateKey(i, j));
            return true;
        }
        
        subResult = exist(board, word, wordIndex+1, i-1, j, solutionChars);
        if (subResult) {
            solutionChars.add(generateKey(i, j));
            return true;
        }
        
        subResult = exist(board, word, wordIndex+1, i, j+1, solutionChars);
        if (subResult) {
            solutionChars.add(generateKey(i, j));
            return true;
        }
        
        subResult = exist(board, word, wordIndex+1, i, j-1, solutionChars);
        if (subResult) {
            solutionChars.add(generateKey(i, j));
            return true;
        }
        
        return false;
    }
    
    public String generateKey(int i, int j) {
        return new StringBuffer().append(i).append("_").append(j).toString();
    }

}
