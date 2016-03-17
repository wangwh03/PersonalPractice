package com.weihua.leetcode;

public class PrimeCounter {
    public int countPrimes(int n) {
        int counter = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(n)) {
                counter++;
            }
        }
        return counter;
    }
    
    private boolean isPrime(int n) {
        if (n < 2 ) {
            return false;
        }
        // Note: Math.sqrt is more expensive than i*i
        for (int i = 2; i*i <= n; i++) {
            if (n % i==0) {
                return false;
            }
        }
        
        return true;
    }
    
}
