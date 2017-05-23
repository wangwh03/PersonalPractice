package com.weihua.leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement tester = new RemoveElement();
//        System.out.println(tester.removeElement(null, -1));
//        int[] nums = {};
//        System.out.println(tester.removeElement(nums, 0));
//        int[] nums2 = {1,2,3,1};
//        System.out.println(tester.removeElement(nums2, 4));
//        int[] nums3 = {1,1,1,1};
//        System.out.println(tester.removeElement(nums3, 1));
        int[] nums4 = {2,2,3};
        System.out.println(tester.removeElement2(nums4, 2));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    // swap and dispose
    public int removeElement2(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int i = 0;
        int length = nums.length;
        while(i < length) {
            if (nums[i] == val) {
                nums[i] = nums[length-1];
                length--;
            } else {
                i++;
            }
        }
        return length;
    }

    // My messy solution, consider handling the actions in else instead of if
    public int removeElement3(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int counter = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                counter++;
                if (i + counter < nums.length) {
                    nums[i] = nums[i + counter];
                }
            } else {
                length++;
            }
        }
        return length;
    }
}
