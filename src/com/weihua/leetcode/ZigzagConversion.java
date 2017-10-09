package com.weihua.leetcode;

public class ZigzagConversion {

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
//        System.out.println(zigzagConversion.convert("", 3));
//        System.out.println(zigzagConversion.convert("a", 3));
//        System.out.println(zigzagConversion.convert("abc", 3));
//        System.out.println(zigzagConversion.convert("abcdefg", 3));
//        System.out.println(zigzagConversion.convert("abcdefg", 2));
//        System.out.println(zigzagConversion.convert("abcdefg", 1));
        System.out.println(zigzagConversion.convert("abcde", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows <= 0) {
            throw new IllegalArgumentException("Row number must be larger than 0");
        } else if (numRows == 1) {
            return s;
        }

        int numCols = s.length();
        Character[][] zigzag = new Character[numRows][numCols];
        int rowIndex = 0;
        int colIndex = 0;
        boolean rowIncrease = true;
        for (int i = 0; i < s.length(); i++) {
            zigzag[rowIndex][colIndex] = s.charAt(i);
            if (rowIncrease) {
                rowIndex++;
            } else {
                colIndex++;
                rowIndex--;
            }

            if (rowIndex == numRows - 1) {
                rowIncrease = false;
            } else if (rowIndex == 0) {
                rowIncrease = true;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (zigzag[i][j] != null) {
                    stringBuilder.append(zigzag[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
