package com.weihua.leetcode;

// Given k list, find the longest common prefixes String
// Simply compare each char of first string and see if it is same in other strings
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] strs = {"", ""};
        System.out.println(test.longestCommonPrefix(strs));
        
        String[] strs2 = {"a", "a"};
        System.out.println(test.longestCommonPrefix(strs2));
        
        String[] strs3 = {"abc", "ab", "a"};
        System.out.println(test.longestCommonPrefix(strs3));
        
        String[] strs4 = {"abcdefsge", "abc", "ab", "abcd"};
        System.out.println(test.longestCommonPrefix(strs4));
    }
    
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char current = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || (strs[j].charAt(i) != current)) {
                    return stringBuilder.toString();
                } 
            }
            stringBuilder.append(current);
        }
        return stringBuilder.toString();
    }
}
