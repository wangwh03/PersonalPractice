package com.weihua.leetcode;

// Given an array and number k, rotate kth number to the end, for example, [1,2,3] k = 1, => [2,3,1]
// O(1) extra buffer, O(n) time.  
// ab = ba is the rotation we want, so we just reverse a, reverse b, then reverse the whole thing
public class RotateArray {

    public static void main(String[] args) {
        RotateArray arrayRotator = new RotateArray();
        int[] nums = {1,2,3,4,5,6};
        arrayRotator.rotate(nums, 3);
        arrayRotator.print(nums);
        System.out.println();
        arrayRotator.reverse(nums, 0, nums.length);
        arrayRotator.print(nums);
        System.out.println();
        int[] nums2 = {1,2,3};
        arrayRotator.reverse(nums2, 1, nums2.length);
        arrayRotator.print(nums2);
    }
    
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
        reverse(nums, 0, nums.length);
    }
    
    public void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int tmp = nums[startIndex];
            nums[startIndex] = nums[endIndex-1];
            nums[endIndex-1] = tmp;
            startIndex++;
            endIndex--;
        }
    }
    
    private void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
