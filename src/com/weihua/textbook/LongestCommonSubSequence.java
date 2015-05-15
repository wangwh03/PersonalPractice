package com.weihua.textbook;

import java.util.HashMap;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        LongestCommonSubSequence test = new LongestCommonSubSequence();
//        System.out.println(test.LCS(null, "a", new HashMap<String, String>()));
//        System.out.println(test.LCS("", null, new HashMap<String, String>()));
//        System.out.println(test.LCS("", "", new HashMap<String, String>()));
        System.out.println(test.LCS("a", "a", new HashMap<String, String>()));
        System.out.println(test.LCS("abcdab", "bdcaba", new HashMap<String, String>()));
    }
    
    public String LCS(String string1, String string2, HashMap<String, String> resultCache) {
        if (string1 == null || string2 == null
                        || string1.equals("") || string2.equals("")) {
            return "";
        }
        
        String key = generateKey(string1.length(), string2.length());
        if (resultCache.containsKey(key)) {
            return resultCache.get(key);
        }
        
        String result;
        if (string1.charAt(string1.length()-1) == string2.charAt(string2.length()-1)) {
            String previousResult = LCS(string1.substring(0, string1.length()-1), string2.substring(0, string2.length()-1), resultCache);
            result = previousResult + string1.charAt(string1.length()-1);
        } else {
            String previousResult1 = LCS(string1.substring(0, string1.length()-1), string2.substring(0, string2.length()), resultCache);
            String previousResult2 = LCS(string1.substring(0, string1.length()), string2.substring(0, string2.length()-1), resultCache);
            if (previousResult1.length() > previousResult2.length()) {
                result = previousResult1;
            } else {
                result = previousResult2;
            }
        }
        resultCache.put(key, result);
        return result;
    }
    
    private String generateKey(int index1, int index2) {
        return index1 + "_" + index2;
    }
    
}
