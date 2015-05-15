package com.weihua.leetcode;

import java.util.HashMap;

public class HouseRobber {

    public int rob(int[] nums) {
        return rob(nums, 0, new HashMap<Integer, Integer>());
    }
    
    public int rob(int[] nums, int startIndex, HashMap<Integer, Integer> cache) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        
        if (cache.containsKey(startIndex)) {
            return cache.get(startIndex);
        }
        
        int totalWithFirst = nums[0] + rob(nums, startIndex+2, cache);
        int totalWithoutFirst = rob(nums, startIndex+1, cache);
        int total = Math.max(totalWithFirst, totalWithoutFirst);
        cache.put(startIndex, total);
        return total;
    }
    
}
