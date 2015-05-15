package com.weihua.careercup.chapter1;

import java.util.HashSet;
import java.util.Set;

// If an element is 0, its entire row and column are set to 0
public class MatrixZeroSetter {

    public static void main(String[] args) {
        MatrixZeroSetter matrixZeroSetter = new MatrixZeroSetter();
        matrixZeroSetter.setZero(null);
        int[][] matrix ={{1}};
        matrixZeroSetter.setZero(matrix);
        PrintUtil.printMatrix(matrix);
        
        int[][] matrix2 = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        matrixZeroSetter.setZero(matrix2);
        PrintUtil.printMatrix(matrix2);
        
        int[][] matrix3 = {{1,2,3},
                        {4,5,6},
                        {7,0,9}};
        matrixZeroSetter.setZero(matrix3);
        PrintUtil.printMatrix(matrix3);
        
    }
    
    public void setZero(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        Set<Integer> visitedRowIndexes = new HashSet<Integer>();
        Set<Integer> visitedColumnIndexes = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visitedRowIndexes.contains(i) && !visitedColumnIndexes.contains(j) && matrix[i][j] == 0) {
                    visitedRowIndexes.add(i);
                    setRowZero(matrix, i);
                    visitedColumnIndexes.add(j);
                    setColumnZero(matrix, j);
                }
            }
        }
    }
    
    private void setRowZero(int[][] matrix, int rowIndex) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[rowIndex][i] = 0;
        }
    }
    
    private void setColumnZero(int[][] matrix, int columnIndex) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[i][columnIndex] = 0;
        }
    }
}
