package com.weihua.leetcode;

/**
 * if all negatives or 0, then first missing is 1
 * if all positives, then largest first missing, is n+1
 * so it's impossible for answer to be <0 or > n+1

 */
public class FirstMissingPositiveFinder {
    public static void main(String[] args) {
        FirstMissingPositiveFinder test = new FirstMissingPositiveFinder();

        int[] nums= {-1,0,12};
        System.out.println(test.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int[] result = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] <= nums.length + 1) {
                result[nums[i]-1] = 1;
            }
        }
        for (int i = 0; i < result.length + 1; i++) {
            if (result[i] == 0) {
                return i+1;
            }
        }

        throw new RuntimeException();
    }

}
