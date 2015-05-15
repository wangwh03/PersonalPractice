package com.weihua.leetcode;

// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i,
// ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
// Find two lines, which together with x-axis forms a container, such that the container contains
// the most water.
//
// Note: You may not slant the container.


// Goal is to max (a1-a2)*min(a1, a2)
// Start from start and end, which has the longest distance, move towards inside, replace and try again to compare with largest so far
public class ContainerWithWater {

    public int getMaxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxArea = 0;

        while (leftIndex < rightIndex) {
            int area = calculateArea(leftIndex, rightIndex, height);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxArea;
    }

    private int calculateArea(int leftIndex, int rightIndex, int[] height) {
        return (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
    }
}
