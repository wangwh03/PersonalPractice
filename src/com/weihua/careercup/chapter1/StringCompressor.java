package com.weihua.careercup.chapter1;


public class StringCompressor {
    
    public static void main(String[] args) {
        StringCompressor compressString = new StringCompressor();
//        System.out.println(compressString.compress(null));
//        System.out.println(compressString.compress("a"));
//        System.out.println(compressString.compress("aaa"));
//        System.out.println(compressString.compress("aabc"));
        System.out.println(compressString.compress("aabcddddddaae"));
    }

    public String compress(String input) {
        if (input == null) {
            return null;
        }
        
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            stringBuffer.append(currentChar);
            
            int j = i;
            int count = 0;
            while(j < input.length() && input.charAt(j) == currentChar) {
                j++;
                count++;
            }
            i = j-1;
            stringBuffer.append(count);
        }
        
        String compressedString = stringBuffer.toString();
        if (compressedString.length() >= input.length()) {
            return input;
        } else {
            return compressedString;
        }
    }
}
