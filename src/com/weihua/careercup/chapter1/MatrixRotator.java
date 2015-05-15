package com.weihua.careercup.chapter1;

import static com.weihua.careercup.chapter1.PrintUtil.printMatrix;

// Rotate a matrix by 90 degrees.  Solution: exchange x,y value with y,x value, and then flip in the center by changing y from 0 to last
// Note: cannot do it in place unless this is N*N square matrix
// Question: what is the difference between clockwise and counter clockwise?
public class MatrixRotator {
    public static void main(String[] args) {
        MatrixRotator matrixRotator = new MatrixRotator();

        int[][] matrixOne = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        int[][] matrixTwo = {{}};
        
        int[][] matrix3 = {{1}};
        
        System.out.println("End of testing print");
        
        matrixRotator.rotate(null);
        matrixRotator.rotate(matrixOne);
        
        matrixRotator.rotate(matrixTwo);
        matrixRotator.rotate(matrix3);
        
        int[][] matrix6 = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        matrixRotator.rotate(matrix6);
        matrixRotator.rotateInPlace(matrix6);
    }
    
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rotatedMatrix[i][j] = matrix[j][matrix.length - 1 - i];
            }
        }
        printMatrix(rotatedMatrix);
    }
    
    public void rotateInPlace(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        printMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
        printMatrix(matrix);
        
    }
    
}
