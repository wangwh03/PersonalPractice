package com.weihua.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HIndex {

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int[] citations = {1,2,3,4,5};
        System.out.println(hIndex.hIndex(citations));
        System.out.println(hIndex.hIndexSorted(citations));
    }
    
    public int hIndex(int[] citations) {
        List<Integer> cit = new ArrayList<Integer>();
        for (int i = 0; i < citations.length; i++) {
            cit.add(citations[i]);
        }
        Collections.sort(cit, Collections.reverseOrder());
        int hIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            hIndex = Math.max(hIndex, Math.min(i+1, cit.get(i)));
        }
        
        return hIndex;
    }
    
    // Assume the input value is in ascending sorted order
    public int hIndexSorted(int[] citations) {
        int hIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            hIndex = Math.max(hIndex, Math.min(i+ 1, citations[citations.length - i-1]));
        }
        
        return hIndex;
    }
}
