package com.weihua.careercup.chapter1;

public final class PrintUtil {

    public static void printMatrix(int[][] matrix) {
        System.out.println();

        if (matrix == null) {
            System.out.println("empty matrix!");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
