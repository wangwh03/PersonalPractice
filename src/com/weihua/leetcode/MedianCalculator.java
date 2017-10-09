package com.weihua.leetcode;

public class MedianCalculator {
    public static void main(String[] args) {
        MedianCalculator calculator = new MedianCalculator();

        int[] nums1 = {2, 6};
        int[] nums2 = {3, 4};
        System.out.println(calculator.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            throw new IllegalArgumentException("input empty!");
        }

        if (nums1 == null || nums1.length == 0) {
            return findMedianSortedArray(nums2, 0, nums2.length - 1);
        } else if (nums2 == null || nums2.length == 0) {
            return findMedianSortedArray(nums1, 0, nums1.length - 1);
        }

        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int leftNum1Index = 0;
        int leftNum2Index = 0;
        int rightNum1Index = nums1.length - 1;
        int rightNum2Index = nums2.length - 1;

        while (leftNum1Index != rightNum1Index &&  leftNum2Index != rightNum2Index) {
            double mid1 = findMedianSortedArray(nums1, leftNum1Index, rightNum1Index);
            double mid2 = findMedianSortedArray(nums2, leftNum2Index, rightNum2Index);
            if (mid1 == mid2) {
                return mid1;
            } else if (mid1 < mid2) {
                int oldLeftNum1Index = leftNum1Index;
                if ((rightNum1Index - leftNum1Index + 1) % 2 == 0) {
                    leftNum1Index = (leftNum1Index + rightNum1Index) / 2 + 1;
                } else {
                    leftNum1Index = (leftNum1Index + rightNum1Index) / 2;
                }
                int diff = leftNum1Index - oldLeftNum1Index;
                rightNum2Index -= diff;
            } else {
                int oldRightNum1Index = rightNum1Index;
                rightNum1Index = (leftNum1Index + rightNum1Index) / 2;
                int diff = oldRightNum1Index - rightNum1Index;
                leftNum2Index += diff;
            }
        }

        if (leftNum1Index == rightNum1Index) {
            return findMedian(nums1[leftNum1Index], nums2, leftNum2Index, rightNum2Index);
        } else {
            return findMedian(nums2[leftNum2Index], nums1, leftNum1Index, rightNum1Index);
        }
    }

    private double findMedian(int num, int[] nums2, int leftNum2Index, int rightNum2Index) {
        if (leftNum2Index == rightNum2Index) {
            return ((double) num + nums2[leftNum2Index]) / 2;
        } else {
            double midNum2 = findMedianSortedArray(nums2, leftNum2Index, rightNum2Index);
            if (num == midNum2) {
                return num;
            }
            if ((rightNum2Index - leftNum2Index + 1) % 2 == 0) {
                if (num < midNum2) {
                    return Math.max(num, nums2[(rightNum2Index + leftNum2Index) / 2]);
                } else {
                    return Math.min(num, nums2[(rightNum2Index + leftNum2Index) / 2 + 1]);
                }
            } else {
                int midIdex = (leftNum2Index + rightNum2Index) / 2;
                if (num < midNum2) {
                    return ((double) (Math.max(num, nums2[midIdex - 1]) + nums2[midIdex])) / 2;
                } else {
                    return ((double) (Math.min(num, nums2[midIdex + 1]) + nums2[midIdex])) / 2;
                }
            }
        }
    }

    private double findMedianSortedArray(int[] nums, int leftIndex, int rightIndex) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("input empty!");
        }
        int midIndex = (leftIndex + rightIndex) / 2;
        int length = rightIndex - leftIndex + 1;
        if (length % 2 == 0) {
            return ((double) (nums[midIndex] + nums[midIndex + 1])) / 2;
        } else {
            return nums[midIndex];
        }
    }
}
