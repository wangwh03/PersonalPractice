package com.weihua.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Given an array of ints, reorder the numbers in such a way that the result forms the largest number
// Create a customized comparator. Simply compare the two possible ints, and decide which number should go first.
// Do not take the trouble to compare the first few digits, etc
// Trickey part, if the array is all zeros, return just one 0
public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
//        int[] nums = {1,2};
        int[] nums = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(largestNumber.largestNumber(nums));
    }
    
    public String largestNumber(int[] nums) {
        List<Integer> numsList = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        Collections.sort(numsList, new LargestNumberComparator());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numsList.size();i++) {
            sb.append(numsList.get(i));
        }
        String result = sb.toString();
        // Note: remember to return 0 if results are all 0s.  0 will never be the first if there is any other non zero numbers
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                return result;
            }
        }
        return "0";
    }
}
