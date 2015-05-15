package com.weihua.leetcode;

import java.util.HashSet;

// Given a number, find the sum of square of each digits. If the sum is eventually 1, then it is a happy number
// If the number is not happy, then the sum will repeat at some point
public class HappyNumber {
    
    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(49));
    }
    
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        
        HashSet<Integer> sumHistory = new HashSet<Integer>();
        int sum = getSum(n);
        while (sum != 1 && !sumHistory.contains(sum)) {
            sumHistory.add(sum);
            n = sum;
            sum = getSum(n);
        }
        
        return sum == 1;
    }
    
    private int getSum(int n) {
        int sum = 0;
        int mod = 0;
        while (n > 0) {
            mod = n % 10;
            sum += Math.pow(mod, 2);
            n = n / 10;
        };
        return sum;
    }
}
