package com.weihua.leetcode;

public class PowerOfThreeJudger {
    public static void main(String[] args) {
        PowerOfThreeJudger tester = new PowerOfThreeJudger();
        System.out.println(tester.isPowerOfThree(0));
        System.out.println(tester.isPowerOfThree(1));
        System.out.println(tester.isPowerOfThree(2));
        System.out.println(tester.isPowerOfThree(3));
        System.out.println(tester.isPowerOfThree(4));
        System.out.println(tester.isPowerOfThree(6));
        System.out.println(tester.isPowerOfThree(9));
        System.out.println(tester.isPowerOfThree(27));
        
        
//        System.out.println(tester.isPowerOfThree(0));
//        System.out.println(tester.isPowerOfThree2(1));
//        System.out.println(tester.isPowerOfThree2(2));
//        System.out.println(tester.isPowerOfThree(3));
//        System.out.println(tester.isPowerOfThree(4));
//        System.out.println(tester.isPowerOfThree(6));
//        System.out.println(tester.isPowerOfThree(9));
//        System.out.println(tester.isPowerOfThree2(27));
        
    }
    
    public boolean isPowerOfThree(int n) {
        if (n <= 0 ) {
            return false;
        }
        int mod;
        while (n > 1) {
            mod = n % 3;
            if (mod != 0) {
                return false;
            } else {
                n = n / 3;
            }
        }
        
        return true;
    }
    
    public boolean isPowerOfThree2(int n) {
        if (n <= 0 ) {
            return false;
        }
        System.out.println(Math.log(n));
        System.out.println(Math.log(3));
        double r = Math.log10(n) / Math.log10(3);
        if (r % 1 == 0)
            return true;
        else
            return false;
    }
    
    public boolean isPowerOfThree3(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int  
        return ( n>0 && 1162261467 % n == 0);
    }
}
