package com.weihua.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatedSubstring {
    public static void main(String[] args) {
        LongestNonRepeatedSubstring tester = new LongestNonRepeatedSubstring();
        System.out.println(tester.lengthOfLongestSubstring(""));
        System.out.println(tester.lengthOfLongestSubstring("a"));
        System.out.println(tester.lengthOfLongestSubstring("ab"));
        System.out.println(tester.lengthOfLongestSubstring("aba"));
        System.out.println(tester.lengthOfLongestSubstring("abacde"));

        System.out.println(tester.getMaxLength("aa"));

    }

    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentLength = getMaxLength(s.substring(i, s.length()));
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }

    public int getMaxLength(String s) {
        Set<Character> uniqueSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (uniqueSet.contains(s.charAt(i))) {
                return i;
            } else {
                uniqueSet.add(s.charAt(i));
            }
        }

        return s.length();
    }
}
