package com.weihua.leetcode;

public class Number1Bit {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Number1Bit test = new Number1Bit();
        System.out.println(test.hammingWeight(0));
        System.out.println(test.hammingWeight(1));
        System.out.println(test.hammingWeight(2));
//        System.out.println(test.hammingWeight(2147483648L));
    }
    
    public int hammingWeight(int n) {
        int counter = 0;
        while ( n != 0 ) {
            counter += n & 1;
            n = n >>> 1;
        }
        return counter;
    }

}
