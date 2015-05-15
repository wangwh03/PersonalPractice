package com.weihua.uber;

public class MatrixSpiralPrinter {

    public static void main(String[] args) {

        MatrixSpiralPrinter test = new MatrixSpiralPrinter();
        int[][] test1 = {{}};
        test.printMatrixInSpiral(test1);

        int[][] test2 = {{1}};
        test.printMatrixInSpiral(test2);

        System.out.println();

        int[][] test3 = {{1,2}, 
                        {3,4}};
        test.printMatrixInSpiral(test3);
        System.out.println();

        int[][] test4 = {{1,2,3},{4,5,6}};
        test.printMatrixInSpiral(test4);
        System.out.println();

        int[][] test5 = {{1,2,3},
                        {4,5,6},
                        {7,8,9},
                        {10,11,12}};
        test.printMatrixInSpiral(test5);
    }

    public void printMatrixInSpiral(int[][] matrix) {
        printRecursive(matrix, 0, matrix.length, 0, matrix[0].length, true, false, false, false);
    }

    public void printRecursive(int[][] matrix, int startRow, int endRow, int startCol, int endCol, 
                    boolean isTopRow, boolean isBottomRow, boolean isLastCol, boolean isFirstCol) {

        if (startRow - endRow == 0 || startCol - endCol == 0) {
            return;
        }
        if (isTopRow) {
            for (int i = startCol; i < endCol; i++) {
                System.out.print(matrix[startRow][i] + " "); // prints 1
            }
            printRecursive(matrix, startRow+1, endRow, startCol, endCol, false, false, true, false); // 1, 1,0,1
        } else if (isLastCol){
            for (int i = startRow; i < endRow; i++) {
                System.out.print(matrix[i][endCol-1] + " ");
            }
            printRecursive(matrix, startRow, endRow, startCol, endCol -1, false, true, false, false);
        } else if (isBottomRow) {
            for (int i = endCol-1; i >= startCol; i--) {
                System.out.print(matrix[endRow-1][i] + " ");
            } 
            printRecursive(matrix, startRow, endRow-1, startCol, endCol, false, false, false, true);
        } else if (isFirstCol){
            for (int i = endRow-1; i >= startRow; i--) {
                System.out.print(matrix[i][startCol] + " ");
            }
            printRecursive(matrix, startRow, endRow, startCol+1, endCol,true, false, false, false);
        }
    }
}
