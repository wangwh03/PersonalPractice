package com.weihua.careercup.chapter9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ChangeMaker {

    public static final int[] CHANGE_VALUES = {25, 10, 5, 1};
    
    public static void main(String[] args) {
        ChangeMaker test = new ChangeMaker();
//        System.out.println(test.makeChange(0, CHANGE_VALUES));
//        System.out.println(test.makeChange(1, CHANGE_VALUES));
//        System.out.println(test.makeChange(2, CHANGE_VALUES));
//        System.out.println(test.makeChange(5, CHANGE_VALUES));
//        System.out.println(test.makeChange(7, CHANGE_VALUES));
        System.out.println(test.makeChange(10, CHANGE_VALUES));
        System.out.println(test.makeChange(25, CHANGE_VALUES));
//        System.out.println(test.makeChange(50, CHANGE_VALUES));
    }
    
    //Note: the following solution will print duplidates solutions for example for sum = 7
    // The printed solution will be [{1=2, 5=1, 25=0, 10=0}, {1=2, 5=1, 25=0, 10=0}, {1=2, 5=1, 25=0, 10=0}, {1=7, 5=0, 25=0, 10=0}]
    // Might need to just change the criteria for change == 1
//    public List<HashMap<Integer, Integer>> makeChange(int sum) {
//        List<HashMap<Integer, Integer>> solutions = new LinkedList<HashMap<Integer,Integer>>();
//        
//        if (sum == 0) {
//            HashMap<Integer, Integer> solution = new HashMap<Integer, Integer>();
//            for (int i = 0; i < CHANGE_VALUES.length; i++) {
//                solution.put(CHANGE_VALUES[i], 0);
//            }
//            solutions.add(solution);
//        }
//        
//        for (int i = 0; i < CHANGE_VALUES.length; i++) {
//            if (sum-CHANGE_VALUES[i] >= 0) {
//                List<HashMap<Integer, Integer>> subSumSolutions = makeChange(sum-CHANGE_VALUES[i]);
//                for (HashMap<Integer, Integer> subSumSolution : subSumSolutions) {
//                    if (subSumSolution.containsKey(CHANGE_VALUES[i])) {
//                        subSumSolution.put(CHANGE_VALUES[i], subSumSolution.get(CHANGE_VALUES[i]) + 1);
//                    } else {
//                        subSumSolution.put(CHANGE_VALUES[i], 1);
//                    }
//                    solutions.add(subSumSolution);
//                }
//            }
//        }
//        
//        return solutions;
//    }
    
    // super frustrated with the special cases
    public List<HashMap<Integer, Integer>> makeChange(int sum, int[] changeValues) {
        List<HashMap<Integer, Integer>> solutions = new LinkedList<HashMap<Integer,Integer>>();

        if (sum == 0) {
            HashMap<Integer, Integer> solution = new HashMap<Integer, Integer>();
            for (int i = 0; i < changeValues.length; i++) {
                solution.put(changeValues[i], 0);
            }
            solutions.add(solution);
            return solutions;
        } else if (changeValues.length == 1 && changeValues[0] == 1) {
            HashMap<Integer, Integer> solution = new HashMap<Integer, Integer>();
            solution.put(1, sum);
            solutions.add(solution);
            return solutions;
        }
        
        for (int i = 0; i < changeValues.length; i++) {
            int maxCount = sum / changeValues[i];
            for (int j = 1; j <= maxCount; j++) {
                List<HashMap<Integer, Integer>> subSolutions = makeChange(sum - j * changeValues[i], Arrays.copyOfRange(changeValues, i+1, changeValues.length));
                for (HashMap<Integer, Integer> subSolution : subSolutions) {
                    subSolution.put(changeValues[i], j);
                    solutions.add(subSolution);
                }
            }
        }
        
        return solutions;
    }
}
