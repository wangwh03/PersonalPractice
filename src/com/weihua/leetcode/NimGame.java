package com.weihua.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NimGame {
    public static void main(String[] args) {
        NimGame tester = new NimGame();
        System.out.println(tester.canWinNim(1));
        System.out.println(tester.canWinNim(2));
        System.out.println(tester.canWinNim(3));
        System.out.println(tester.canWinNim(4));
        System.out.println(tester.canWinNim(42));
        System.out.println(tester.canWinNim(1348820612));
    }

    public boolean canWinNim(int n) {
        return canWinNim(n, new HashMap<>()); 
    }

    // Recursion will have stack overflow once n is large like 1348820612
    private boolean canWinNim(int n, Map<Integer, Boolean> cache) {
        if (n <= 3) {
            return true;
        }
        
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            boolean result = !(canWinNim(n-1, cache) || canWinNim(n-2, cache) || canWinNim(n-3, cache));
            cache.put(n, result);
            return result;
        }
    }
    
    // fill up DB table from 1 to n, then the pattern is clear: n % 4 == 0 then cannot win
    public boolean canWinNim2(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("number should be positive");
        }
        return n % 4 != 0;
    }
}
