package com.weihua.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplidateII {
    public static void main(String[] args) {
        ContainsDuplidateII tester = new ContainsDuplidateII();
//        System.out.println(tester.containsNearbyDuplicate(null, 0));
        int[] nums = {1,2};
//        System.out.println(tester.containsNearbyDuplicate(nums, 0));

        int[] nums2 = {1,0,1,1};
        System.out.println(tester.containsNearbyDuplicate(nums2, 1));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return false;
        }
        // create a hashmap and check each element to make time linear
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueToIndex.containsKey(nums[i]) && (i - valueToIndex.get(nums[i]) <= k)) {
                return true;
            } else {
                valueToIndex.put(nums[i], i);
            }
        }
        return false;
    }
}
