package com.weihua.leetcode;

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes tester = new MoveZeroes();
        tester.moveZeroes3(null);
        int[] nums = {0};
        tester.moveZeroes3(nums);
        tester.print(nums);
        
        int nums2[] = {1, 0, 2};
        tester.moveZeroes3(nums2);
        tester.print(nums2);
        
        int nums3[] = {0, 0, 0, 0, 0, 0};
        tester.moveZeroes3(nums3);
        tester.print(nums3);

        int nums4[] = {0,1,0,3,12};
        tester.moveZeroes3(nums4);
        tester.print(nums4);
        
        int nums5[] = {1,3,12};
        tester.moveZeroes3(nums5);
        tester.print(nums5);
    }
        
    
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        
        int[] results = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                results[index] = nums[i];
                index++;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = results[i];
        }    
    }
    
    // In place
    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j == nums.length) {
                    return;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
    
    // In place faster
    public void moveZeroes3(int[] nums) {
        if (nums == null) {
            return;
        }
        
        int nonZeroCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroCounter] = nums[i];
                nonZeroCounter++;
            } 
        }
        for (int i = nonZeroCounter; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    
    public void print(int[] nums) {
        for (int i = 0; i< nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
