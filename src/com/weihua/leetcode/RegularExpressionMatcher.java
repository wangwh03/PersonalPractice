package com.weihua.leetcode;


public class RegularExpressionMatcher {
    public static void main(String[] args) {
        RegularExpressionMatcher matcher = new RegularExpressionMatcher();
        System.out.println(matcher.isMatch("aa", "a"));
        System.out.println(matcher.isMatch("aa", "aa"));
        System.out.println(matcher.isMatch("aa", "a*"));
        System.out.println(matcher.isMatch("ab", ".*"));
        System.out.println(matcher.isMatch("aa", ".*"));
        System.out.println(matcher.isMatch("aab", "c*a*b"));
        System.out.println(matcher.isMatch("ab", ".*c"));
        System.out.println(matcher.isMatch("a", "ab*"));
        System.out.println(matcher.isMatch("bbbba", ".*a*a"));
    }

    public boolean isMatch(String input, String pattern) {
        if (pattern.length() == 0) {
            return input.length() == 0;
        } else if (input.length() == 0) {
            if (pattern.length() % 2 != 0) {
                return false;
            }
            for (int i = 1; i < pattern.length(); i = i+2) {
                if (pattern.charAt(i) != '*') {
                    return false;
                }
            }

            return true;
        }
        
        if (pattern.charAt(0) == '.') {
            if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
                int i = 0;
                while (i <= input.length()) {
                    if(isMatch(input.substring(i), pattern.substring(2))) {
                        return true;
                    }
                    i++;
                }
                return false;
            } else {
                return isMatch(input.substring(1, input.length()), pattern.substring(1, pattern.length()));
            }
        } else if (input.charAt(0) == pattern.charAt(0)) {
            if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
                int i = 0;
                while (i < input.length() && input.charAt(i) == pattern.charAt(0)) {
                    if(isMatch(input.substring(i), pattern.substring(2))) {
                        return true;
                    }
                    i++;
                }
                return isMatch(input.substring(i), pattern.substring(2));
            } else {
                return isMatch(input.substring(1), pattern.substring(1));
            }
        } else {
            if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
                return isMatch(input, pattern.substring(2));
            } else {
                return isMatch(input, pattern.substring(1));
            }
        }
    }

}
