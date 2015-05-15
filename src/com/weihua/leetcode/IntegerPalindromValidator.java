package com.weihua.leetcode;

// Validate if an interger is panlindrom, tricky part is to get both int at both side, and then substract them
public class IntegerPalindromValidator {
    public static void main(String[] args) {
        IntegerPalindromValidator validator = new IntegerPalindromValidator();
//        System.out.println(validator.isPalindrome(0));
//        System.out.println(validator.isPalindrome(10));
//        System.out.println(validator.isPalindrome(1001));
//        System.out.println(validator.isPalindrome(121));
        System.out.println(validator.isPalindrome(9999));
        System.out.println(validator.isPalindrome(-121));
        System.out.println(validator.isPalindrome(-1121));
        System.out.println(validator.isPalindrome(Integer.MAX_VALUE));
        System.out.println(validator.isPalindrome(Integer.MIN_VALUE));
    }
    
    public boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }
        int leftBase = 1;
        while (x/leftBase >= 10) {
            leftBase *= 10;
        }
        
        int rightBase = 10;
        while (leftBase >= rightBase) {
            int leftNumber =  x/leftBase;
            int rightNumber =  x % rightBase;
            if (leftNumber != rightNumber) {
                return false;
            }
            x = (int) (x - leftNumber*leftBase)/10;
            leftBase /= 100;
        }
        return true;
    }
}
