package com.weihua.leetcode;

import java.util.Comparator;

public class LargestNumberComparator implements Comparator<Integer>{
    
    public static void main(String[] args) {
        LargestNumberComparator comparator = new LargestNumberComparator();
//        System.out.println(comparator.compare(9, 10));
        System.out.println(comparator.compare(1, 2));
        System.out.println(comparator.compare(9, 0));
    }
    
    public int compare(Integer n1, Integer n2) {
        String s1 = n1+""+n2;
        String s2 = n2+""+n1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return -1;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return 1;
            } 
        }
        return 0;
    }
    
}
