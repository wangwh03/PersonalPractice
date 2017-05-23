package com.weihua.leetcode;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        ExcelColumnTitle tester = new ExcelColumnTitle();
        System.out.println(tester.convertToTitle(1));
        System.out.println(tester.convertToTitle(2));
        System.out.println(tester.convertToTitle(26));
        System.out.println(tester.convertToTitle(27));
    }

    public String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            char resultChar = convertIntToChar((n-1) % 26);
            result = resultChar + result;
            n = (n-1) / 26;
        }
        return result;
    }

    private char convertIntToChar(int n) {
        return (char) (n + 'A');
    }
}
