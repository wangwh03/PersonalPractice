package com.weihua.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementFinder {

    public static void main(String[] args) {
        MajorityElementFinder test = new MajorityElementFinder();
        int[] nums = {1,2,3,1,1};
        System.out.println(test.find(nums));
    }
    
    public int find(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Empty numbers!");
        }
        
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (frequency.containsKey(nums[i])) {
                frequency.put(nums[i], frequency.get(nums[i])+1);
            } else {
                frequency.put(nums[i], 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> element : frequency.entrySet()) {
            if (element.getValue() > nums.length/2) {
                return element.getKey();
            }
        }
        throw new IllegalArgumentException("Required element does not exist");
    }
}
