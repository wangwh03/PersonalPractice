package com.weihua.leetcode;

public class PlusOne {
    // null
    // 1
    // 9
    // 999
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        int previous = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int currentSum = digits[i] + previous;
            previous = currentSum / 10;
            digits[i] = currentSum % 10;
        }

        if (previous > 0) {
            int[] result = new int[digits.length+1];
            result[0] = previous;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i-1];
            }
            return result;
        } else {
            return digits;
        }
    }
}
