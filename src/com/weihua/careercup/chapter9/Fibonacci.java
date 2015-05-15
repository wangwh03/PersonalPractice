package com.weihua.careercup.chapter9;

import java.util.HashMap;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.getFibonacci(48));
//        System.out.println(fibonacci.getFibonacci(1));
//        System.out.println(fibonacci.getFibonacci(2));
//        System.out.println(fibonacci.getFibonacci(3));
//        System.out.println(fibonacci.getFibonacci(4));
//        System.out.println(fibonacci.getFibonacci(5));
//        
//
//        System.out.println(fibonacci.getFobpmacciNonResursive(0));
//        System.out.println(fibonacci.getFobpmacciNonResursive(1));
//        System.out.println(fibonacci.getFobpmacciNonResursive(2));
//        System.out.println(fibonacci.getFobpmacciNonResursive(3));
//        System.out.println(fibonacci.getFobpmacciNonResursive(4));
//        System.out.println(fibonacci.getFobpmacciNonResursive(5));
        
//        System.out.println();
//        System.out.println(fibonacci.getFibonacciSequence(5));
    }
    
    public int getFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0 || n == 1) {
            return n;
        }
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        cache.put(0, 0);
        cache.put(1, 1);
        return getFibonacci(n, cache);
    }
    
    private int getFibonacci(int n, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int result = getFibonacci(n-1, cache) + getFibonacci(n-2, cache);
            cache.put(n, result);
            return result;
        }
    }
    
    public int getFibonacciSequence(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0 || n == 1) {
            System.out.println(n);
            return n;
        }
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        cache.put(0, 0);
        cache.put(1, 1);
        return getFibonacciSequence(n, cache);
    }
    
    private int getFibonacciSequence(int n, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            System.out.println(cache.get(n));
            return cache.get(n);
        } else {
            int result = getFibonacci(n-1, cache) + getFibonacci(n-2, cache);
            cache.put(n, result);
            System.out.println(result);
            return result;
        }
    }
    
    public int getFobpmacciNonResursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int previousNumber = 1;
        int previousTwoNumber = 0;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = previousNumber + previousTwoNumber;
            previousTwoNumber = previousNumber;
            previousNumber = result;
        }
        
        return result;
    }
}

