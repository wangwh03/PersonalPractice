package com.weihua.leetcode;

public class WordCounter {

    public static void main(String[] args) {
        WordCounter counter = new WordCounter();
        System.out.println(counter.count(null));
        System.out.println(counter.count(""));
        System.out.println(counter.count("  "));
        System.out.println();
        System.out.println(counter.count(" a"));
        System.out.println(counter.count(" a "));
        System.out.println(counter.count(" this is a test "));
        System.out.println(counter.count(" this is a test"));
    }
    
    public int count(String input) {
        if (input == null) {
            return 0;
        }
        
        input = input.trim();
        if (input.length() == 0) {
            return 0;
        }
        
        int counter = 0;
        for (int i = 0; i < input.length()-2; i++) {
            if (isLetter(input.charAt(i)) && input.charAt(i+1) == ' ') {
                counter++;
            }
         }
        
        if (isLetter(input.charAt(input.length()-1))) {
            counter++;
        }
        
        return counter;
    }
    
    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
