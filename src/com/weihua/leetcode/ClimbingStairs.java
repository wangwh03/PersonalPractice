package com.weihua.leetcode;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs tester = new ClimbingStairs();
//        System.out.println(tester.climbStairs(1));
//        System.out.println(tester.climbStairs(2));
//        System.out.println(tester.climbStairs(3));
        System.out.println(tester.climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Invalid input!");
        }
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int previous1 = 1;
            int previous2 = 2;
            int result = 0;
            for (int i = 3; i <= n; i++) {
                result = previous1 + previous2;
                previous1 = previous2;
                previous2 = result;
            }
            return result;
        }
    }
}
