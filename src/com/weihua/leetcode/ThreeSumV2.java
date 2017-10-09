package com.weihua.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
challenge is overflow case
 */
public class ThreeSumV2 {
    /*
    a+b = -2^31
    c = 2^31 ->overflow
    if 
    a+b=-c
    for {c}
    for a {
    find -c-a}

    overflow: a b positive, c negative, then -c?
     */

    public static void main(String[] args) {
        ThreeSumV2 test = new ThreeSumV2();
//        System.out.println(test.threeSum(null));

//        int[] nums1 = {0};
//        System.out.println(test.threeSum(nums1));
//
//        int[] nums2 = {-1, 0, 1};
//        System.out.println(test.threeSum(nums2));

        int[] nums3 = {-4,2,2,2}; // -1 -1 0 1 2
        System.out.println(test.threeSum(nums3));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Set<String> uniqueResults = new HashSet<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> numOfOccuranceByInput = new LinkedHashMap<>();
        for (int j = 0; j < nums.length; j++) {
            if (numOfOccuranceByInput.containsKey(nums[j])) {
                numOfOccuranceByInput.put(nums[j], numOfOccuranceByInput.get(nums[j]) + 1);
            } else {
                numOfOccuranceByInput.put(nums[j], 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            solution2WithHashMap(nums, i, uniqueResults, results, numOfOccuranceByInput);
        }
        return results;
    }

    /*
    Solution 2 uses hashmap by creating just one hashmap overall. This is fastest but not error prone, considering so many conditions you need to consider
     */
    private void solution2WithHashMap(int[] nums, int i, Set<String> uniqueResults, List<List<Integer>> results, Map<Integer, Integer> numOfOccuranceByInput) {
        for (int j = i+1; j < nums.length; j++) {
            int sum = - nums[i];
            if ((sum - nums[j] != nums[j] && numOfOccuranceByInput.containsKey(sum - nums[j]) && (sum - nums[j] > nums[j])) ||
                    (sum - nums[j] == nums[j] && nums[j] != nums[i] && numOfOccuranceByInput.get(nums[j]) >= 2) ||
                    (sum - nums[j] == nums[j] && nums[j] == nums[i] && numOfOccuranceByInput.get(nums[j]) >= 3)) {
                if (!uniqueResults.contains("" + nums[i] + nums[j] + (sum - nums[j]))) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(sum - nums[j]);
                    results.add(result);
                    uniqueResults.add("" + nums[i] + nums[j] + (sum - nums[j]));
                }
            }
        }
    }

    /*
    Brute force - simpliest error prone solution, slow though.
     */
    private void solution1(int[] nums, int i, Set<String> uniqueResults, List<List<Integer>> results) {
        for (int j = i+1; j < nums.length; j++) {
            if (nums[i] + nums[j] > 0) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[k] > 0) {
                        continue;
                    }
                    validAndCheckResult(nums, i, j, k, uniqueResults, results);
                }
            } else {
                for (int k = nums.length - 1; k > j; k--) {
                    if (nums[k] < 0) {
                        continue;
                    }
                    validAndCheckResult(nums, i, j, k, uniqueResults, results);
                }
            }
        }
    }

    private void validAndCheckResult(int[] nums, int i, int j, int k, Set<String> uniqueResults, List<List<Integer>> results) {
        if (nums[i] + nums[j] + nums[k] == 0) {
            if (!uniqueResults.contains("" + nums[i] + nums[j] + nums[k])) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[i]);
                result.add(nums[j]);
                result.add(nums[k]);
                results.add(result);
                uniqueResults.add("" + nums[i] + nums[j] + nums[k]);
            }
        }
    }

}
