package com.weihua.leetcode;

import java.util.Arrays;

public class AnagramValidator {
    public static void main(String[] args) {
        AnagramValidator validator = new AnagramValidator();
        System.out.println(validator.isAnagram(null, null));
        System.out.println(validator.isAnagram("", null));
        System.out.println(validator.isAnagram(null, ""));
        System.out.println(validator.isAnagram("",""));
        System.out.println(validator.isAnagram("abc", "abc"));
        System.out.println(validator.isAnagram("abc", "cba"));
        System.out.println(validator.isAnagram("anagram", "nagaram"));
        System.out.println(validator.isAnagram("rat", "car"));
    }
    
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null ) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        
        char[] firstCharArray = s.toCharArray();
        Arrays.sort(firstCharArray);
        char[] secondCharArray = t.toCharArray();
        Arrays.sort(secondCharArray);

        return Arrays.equals(firstCharArray,  secondCharArray);
    }
    
}
