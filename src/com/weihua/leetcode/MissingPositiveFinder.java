package com.weihua.leetcode;

// Given an array, find the first missing positive
// [1,2,0], [3,4,-1]
// Solution 1: create a hashset, for i = 1:array.length, if i does not exist in hashset, then return
// Solution 2: linear, no extra space. if a[i] = k, then swap a[i] with a[k], after one scan a[i] should all equals to i.
// For the first one that a[i]!=i is the missting positive.  Or the length of the array
public class MissingPositiveFinder {

    public static void main(String[] args) {
        MissingPositiveFinder finder = new MissingPositiveFinder();
        int[] test1 = null;
        System.out.println(finder.findMissingPositive(test1));
        
        int[] test2 = {};
        System.out.println(finder.findMissingPositive(test2));
        
        int[] test3 = {1};
        System.out.println(finder.findMissingPositive(test3));
        
        int[] test4 = {1,2};
        System.out.println(finder.findMissingPositive(test4));

        int[] test5 = {1,2, 0};
        System.out.println(finder.findMissingPositive(test5));
        
        int[] test6 = {1,2, 3, -1, -10, 100};
        System.out.println(finder.findMissingPositive(test6));
    }
    
    public int findMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= 1 && nums[i] <= length) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        
        for (int i = 0; i < length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        
        return length+1;
    }
}
