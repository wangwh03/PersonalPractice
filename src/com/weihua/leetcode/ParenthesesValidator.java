package com.weihua.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ParenthesesValidator {

    public static void main(String[] args) {
        ParenthesesValidator validator = new ParenthesesValidator();
        int[] test = {0,4,3,0};
        int[] result = validator.twoSum(test, 0);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
    
    public int[] twoSum(int[] numbers, int target) throws IllegalArgumentException {
        int[] resultIndexes = new int[2];
        HashMap<Integer,Integer> numberMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < numbers.length; i++) {
            numberMap.put(numbers[i], i+1);    
        }
        
        for (Map.Entry<Integer, Integer> element : numberMap.entrySet()) {
            if (numberMap.containsKey(target - element.getKey())) {
                int index1 = element.getValue();
                int index2 = numberMap.get(target - element.getKey());
                
                resultIndexes[0] = Math.min(index1, index2);
                resultIndexes[1] = Math.max(index1, index2);
                return resultIndexes;
            }
        }
        
        throw new IllegalArgumentException("ah");
    }
        
}
