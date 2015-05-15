package com.weihua.leetcode;

// Reverse an int. what to do if overflow?
public class RevertInteger {

    public static void main(String[] args) {
        RevertInteger revertInteger = new RevertInteger();
        System.out.println(revertInteger.reverse(0));
        System.out.println(revertInteger.reverse(1));
        System.out.println(revertInteger.reverse(10));
        System.out.println(revertInteger.reverse(123));
        System.out.println(revertInteger.reverse(-2147483648));
    }
    
    public int reverse(int x) {
        long currentDigit = 0;
        long result = 0;
        while (x != 0) {
            currentDigit = x % 10;
            result = result* 10 + currentDigit;
            x = x/10;
        }
        if (x < 0) {
            result *= -1;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) result;
        }
    }
}
