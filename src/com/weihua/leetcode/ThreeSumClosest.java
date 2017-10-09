package com.weihua.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest test = new ThreeSumClosest();
        int[] nums = {1,2,5,10,11};
//        System.out.println(test.threeSumClosest(nums, 0));
//        System.out.println(test.threeSumClosest(nums, 2));
//        System.out.println(test.threeSumClosest(nums, 5));
//        System.out.println(test.threeSumClosest(nums, -2));
        System.out.println(test.threeSumClosest(nums, 12));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException(" input size should be >= 3");
        }

        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            // two sum problem
            int leftIndex = i+1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int currentSum = nums[leftIndex] + nums[rightIndex] + nums[i];
                if (currentSum == target) {
                    return target;
                }
                if (currentSum > target) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
                if (Math.abs(closestSum - target) > Math.abs(currentSum - target)) {
                    closestSum = currentSum;
                }
            }
        }

        return closestSum;
    }
}
