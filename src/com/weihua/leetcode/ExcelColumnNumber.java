package com.weihua.leetcode;

public class ExcelColumnNumber {
    public static void main(String[] args) {
        ExcelColumnNumber tester = new ExcelColumnNumber();
        System.out.println(tester.titleToNumber("A"));
        System.out.println(tester.titleToNumber("Z"));
        System.out.println(tester.titleToNumber("AA"));
        System.out.println(tester.titleToNumber("AB"));
    }
    
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("input cannot be empty or null");
        }
        
        int columnNumber = convertCharToNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            columnNumber = columnNumber * 26 + convertCharToNumber(s.charAt(i));
        }
        
        return columnNumber;
    }
    
    private int convertCharToNumber(char input) {
        return input - 'A' + 1;
    }
}
