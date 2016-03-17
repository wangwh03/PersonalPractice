package com.weihua.leetcode;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/word-pattern/
public class WordPattern {
    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern.wordPattern("abba", "cat dog dog cat"));
    }
    
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> mapping = new HashMap<>();
        HashSet<String> existingWords = new HashSet<>();
        String[] words = str.split("\\s+");
        if (pattern.length() != words.length) {
            return false;
        }
        
        for (int i = 0; i < pattern.length(); i++) {
            if (!mapping.containsKey(pattern.charAt(i))) {
                if (existingWords.contains(words[i])) {
                    return false;
                }
                mapping.put(pattern.charAt(i), words[i]);
                existingWords.add(words[i]);
            } else {
                if (!mapping.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
