package com.weihua.leetcode;

// Algorithm is here http://en.wikipedia.org/wiki/Permutation
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        permutation.generateNextPermutation(null);
//        int[] num = {};
//        permutation.generateNextPermutation(num);
//
//        int[] num2 = {1};
//        permutation.generateNextPermutation(num2);
//        permutation.printArray(num2);
//
//        int[] num3 = {Integer.MAX_VALUE};
//        permutation.generateNextPermutation(num3);
//        permutation.printArray(num3);
//        
        int[] num4 = {1,3,2};
        permutation.generateNextPermutation(num4);
        permutation.printArray(num4);
        
        int[] num5 = {Integer.MAX_VALUE, Integer.MIN_VALUE, 5, 100, 20, 1,1,1,1,1,1};
        permutation.generateNextPermutation(num5);
        permutation.printArray(num5);
    }
    
    public void generateNextPermutation(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }
        
        int leftIndex = num.length-2;
        while (leftIndex >= 0 && num[leftIndex] >= num[leftIndex+1]) {
            leftIndex--;
        }
        if (leftIndex < 0) {
            reverse(num, 0, num.length-1);
            return;
        }
        
        int rightIndex = num.length-1;
        while (rightIndex > leftIndex && num[rightIndex] <= num[leftIndex]) {
            rightIndex--;
        }
        
        swap(num, leftIndex, rightIndex);
        
        reverse(num, leftIndex+1, num.length-1);
    }
    
    private void reverse(int[] num, int leftIndex, int rightIndex) {
        for (int i = 0; i <= (rightIndex-leftIndex)/2; i++) {
            swap(num, leftIndex+i, rightIndex-i);
        }
    }
    
    private void swap(int[] num, int firstIndex,int secondIndex) {
        int tmp = num[firstIndex];
        num[firstIndex] = num[secondIndex];
        num[secondIndex] = tmp;
    }
    
    private void printArray(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+"\t");
        }
        System.out.println();
    }
}
