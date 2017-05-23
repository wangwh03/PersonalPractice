package com.weihua.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public static void main(String[] args) {
        PascalTriangle2 tester = new PascalTriangle2();
        System.out.println(tester.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> previousLevel = new ArrayList<>();
        previousLevel.add(1);
        if (rowIndex == 0) {
            return previousLevel;
        }

        List<Integer> levelI = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            levelI = new ArrayList<>();
            levelI.add(1);

            for (int j = 1; j < i; j++) {
                levelI.add(previousLevel.get(j-1)+previousLevel.get(j));
            }

            levelI.add(1);
            previousLevel = levelI;
        }

        return levelI;
    }
}
