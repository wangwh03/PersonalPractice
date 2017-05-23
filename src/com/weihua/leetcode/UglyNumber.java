package com.weihua.leetcode;

public class UglyNumber {
    private static final int[] BASE_NUMBERS = {2, 3, 5};

    public static void main(String[] args) {
        UglyNumber tester = new UglyNumber();
        System.out.println(tester.isUgly(0));
        System.out.println(tester.isUgly(1));
        System.out.println(tester.isUgly(2));
        System.out.println(tester.isUgly(3));
        System.out.println(tester.isUgly(5));
        System.out.println(tester.isUgly(14));
        System.out.println(tester.isUgly(1024));
    }

    public boolean isUgly(int num) {
        // is positive
        // record primary factors
        // check only 2,3,5
        if (num <= 0) {
            return false;
        } else {
            //find all primary factors; check if is 2,3,5
            return isUglyHelper(num);
        }
    }

    private boolean isUglyHelper(int num) {
        if (num == 1) {
            return true;
        }

        for (int i = 0; i < BASE_NUMBERS.length; i++) {
            if (num % BASE_NUMBERS[i] == 0) {
                return isUglyHelper(num / BASE_NUMBERS[i]);
            }
        }
        return false;
    }

    // Other people's solution
    public boolean isUgly2(int num) {
        if(num<=0) return false;
        while(num%2==0) num/=2;
        while(num%3==0) num/=3;
        while(num%5==0) num/=5;
        return num == 1;
    }
}
