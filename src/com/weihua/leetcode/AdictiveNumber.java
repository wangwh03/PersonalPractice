package com.weihua.leetcode;

public class AdictiveNumber {

    public static void main(String[] args) {
        AdictiveNumber adictiveNumber = new AdictiveNumber();
//        System.out.println(adictiveNumber.isAdditiveNumber("1"));
//        System.out.println(adictiveNumber.isAdditiveNumber("12"));
        System.out.println(adictiveNumber.isAdditiveNumber("8917"));
    }
    
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        
        return isAddictive(num, 1, 1);
    }
    
    private boolean isAddictive(String num, int firstNumLen, int secondNumLen) {
        int current1 = convertToInt(num.substring(0, firstNumLen));
        int current2 = convertToInt(num.substring(firstNumLen, firstNumLen + secondNumLen));
        long sum = current1 + current2;
        int sumLen = getLen(sum);
        //convert substring to int
        int actualSum = convertToInt(num.substring(firstNumLen + secondNumLen, firstNumLen + secondNumLen + sumLen));
        if (sum == actualSum) {
            if (firstNumLen + secondNumLen + sumLen == num.length()) {
                return true;
            }
            return isAddictive(num.substring(firstNumLen), secondNumLen, 1);
        } else {
            return false;
        }
    }
    
    private int getLen(long number) {
        int len = 0;
        while (number > 0) {
            len++;
            number = number / 10;
        }
        return len;
    }
    
    private int convertToInt(String string) {
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            result += result*10 + string.charAt(i) - '0';
        }
        return result;
    }
}
