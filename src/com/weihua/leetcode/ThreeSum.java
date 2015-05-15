package com.weihua.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {};
        System.out.println(threeSum.threeSum(nums));

        int[] nums2 = {1,2,3,4};
        System.out.println(threeSum.threeSum(nums2));

        int[] nums3 = {1,-1,0};
        System.out.println(threeSum.threeSum(nums3));

        int[] nums4 = {1,1,1,-1,-1,0};
        System.out.println(threeSum.threeSum(nums4));
        
        int[] nums5 = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        System.out.println(threeSum.threeSum(nums5));
        
        int[] nums6 = {0,0,0,0};
        System.out.println(threeSum.threeSum(nums6));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();

        if (nums.length < 2) {
            return solutions;
        }

        HashMap<Integer, Integer> f = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (f.containsKey(nums[i])) {
                f.put(nums[i], f.get(nums[i]) + 1);
            } else {
                f.put(nums[i], 1);
            }
        }

        HashSet<String> results = new HashSet<String>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> subSolutions = findTwoSum(-nums[i], f);
            for (List<Integer> s : subSolutions) {
                s.add(nums[i]);
                String resultKey = getResultSorted(s);
                if (!results.contains(resultKey)) {
                    solutions.add(s);
                    results.add(resultKey);
                }
            }
        }
        return solutions;
    }
    
    private String getResultSorted(List<Integer> solution) {
        Collections.sort(solution);
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < solution.size(); i++) {
            resultBuilder.append(solution.get(i)).append("_");
        }
        return resultBuilder.toString();
    }

    public List<List<Integer>> findTwoSum(int sum, HashMap<Integer, Integer> f) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        for (Integer key : f.keySet()) {
            int otherKey = sum-key;
            if ((otherKey != key && f.containsKey(otherKey)) 
                            || otherKey == key && f.get(otherKey) > 1) {
                List<Integer> s = new ArrayList<Integer>();
                s.add(key);
                s.add(otherKey);
                solutions.add(s);
            }
        }
        return solutions;
    }

}
