package com.weihua.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] pattern1 = getPattern(s);
        int[] pattern2 = getPattern(t);

        for (int i = 0; i < pattern1.length; i++) {
            if (pattern1[i] != pattern2[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] getPattern(String input) {
        Map<Character, Integer> charToIndexMapping1 = new HashMap<>();
        int[] pattern = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if (!charToIndexMapping1.containsKey(input.charAt(i))) {
                charToIndexMapping1.put(input.charAt(i), charToIndexMapping1.size()+1);
            }
            pattern[i] = charToIndexMapping1.get(input.charAt(i));
        }
        return pattern;
    }
}
