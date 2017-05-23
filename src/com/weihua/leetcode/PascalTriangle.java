package com.weihua.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle tester = new PascalTriangle();
//        System.out.println(tester.generate(0));
//        System.out.println(tester.generate(1));
//        System.out.println(tester.generate(2));
        System.out.println(tester.generate(3));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> previousLevel = new ArrayList<>();
        previousLevel.add(1);
        result.add(previousLevel);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> levelI = new ArrayList<>();
            levelI.add(1);

            for (int j = 1; j < i-1; j++) {
                levelI.add(previousLevel.get(j-1) + previousLevel.get(j));
            }

            levelI.add(1);
            result.add(levelI);
            previousLevel = levelI;
        }
        return result;
    }
}
