package com.weihua.leetcode;

import java.util.HashSet;

public class LongestSubString {
    
    public static void main(String[] args) {
        LongestSubString test = new LongestSubString();
//        System.out.println(test.lengthOfLongestSubstring("a"));
//        System.out.println(test.lengthOfLongestSubstring("aa"));
        System.out.println(test.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        
        int previousLongest = 0;
        int previousLongestWithCurrent = 0;
        
        int longestWithCurrent = 0;
        int currentLongest = 0;
        
        HashSet<Character> longestWithCurrentChars = new HashSet<Character>();

        for (int i = 0; i < input.length(); i++) {
            if (longestWithCurrentChars.contains(input.charAt(i))) {
                longestWithCurrent = 1;
                longestWithCurrentChars = new HashSet<Character>();
            } else {
                longestWithCurrent = previousLongestWithCurrent + 1;
            }
            longestWithCurrentChars.add(input.charAt(i));

            currentLongest = Math.max(previousLongest, longestWithCurrent);
            
            previousLongestWithCurrent = longestWithCurrent;
            previousLongest = currentLongest;
        }
        
        return currentLongest;
    }
}
