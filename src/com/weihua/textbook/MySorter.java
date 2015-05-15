package com.weihua.textbook;

import java.util.Random;


public class MySorter {

    public static void main(String[] args) {
        MySorter sorter = new MySorter();
        int[] test = {1,2,5,4,10};
        sorter.insertSort(null);
        sorter.insertSort(test);

        int[] test2 = {1,22,55555,4444,333};
        sorter.insertSort(test2);

        int[] test3 = {1,2,5,4,10, 1,1,1,1,1,1,11,};
        sorter.insertSort(test3);

        int[] test4 = {1,2,5};
        sorter.mergeSort(null);
        sorter.mergeSort(test4);

        int[] test5 = {1,22,55555,4444,333};
        sorter.mergeSort(test5);

        int[] test6 = {1,2,5,4,10, 1,1,1,1,1,1,11,};
        sorter.mergeSort(test6);

        int[] test7 = {1,2,5};
        sorter.quickSort(null);
        sorter.quickSort(test7);

        int[] test8 = {1,22,55555,4444,333};
        sorter.quickSort(test8);

        int[] test9 = {1,2,5,4,10, 1,1,1,1,1,1,11,};
        sorter.quickSort(test9);

    }

    // In place.  first element is sorted, starting from the second until end, insert current number into first 0 to j-1 sorted element.
    public void insertSort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }

        for (int i = 1; i < input.length; i++) {
            int j = i-1;
            int current = input[i];
            while (j >= 0 && current < input[j]) {
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = current;
        }
        System.out.println("insert sort");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + "\t");
        }
        System.out.println();
    }

    public void mergeSort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        mergeSort(input, 0, input.length-1);
        System.out.println("merge sort");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + "\t");
        }
        System.out.println();
    }

    private void mergeSort(int[] input, int p, int q) {
        if (p < q) {
            int m = (p+q) / 2;
            mergeSort(input, p, m);
            mergeSort(input, m+1, q);
            merge(input, p, m, q);
        }
    }

    public void merge(int[] input, int left, int middle, int right) {
        int leftLength = middle-left+1;
        int rightLength = right - middle;
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];
        for (int i = left; i <= middle; i++) {
            leftArray[i-left] = input[i];
        }

        for (int i = middle+1; i <= right; i++) {
            rightArray[i-middle-1] = input[i];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int currentIndex = left;
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                input[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                input[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }
        while (leftIndex < leftLength) {
            input[currentIndex] = leftArray[leftIndex];
            leftIndex++;
            currentIndex++;
        }
        while (rightIndex < rightLength) {
            input[currentIndex] = rightArray[rightIndex];
            rightIndex++;
            currentIndex++;
        }
    }

    public void quickSort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        quickSort(input, 0, input.length-1);
        System.out.println("quick sort");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + "\t");
        }
        System.out.println();
    }

    private void quickSort(int[] input, int l, int r) {
        if (l < r) {
            int pivotalIndex = partition(input, l, r);
            quickSort(input, l, pivotalIndex-1);
            quickSort(input, pivotalIndex+1, r);
        }
    }

    private int partition(int[] input, int l, int r) {
        int index = generateRandomIndex(l, r);
        swap(input, index, r);
        int pivotal = input[r];

        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (input[j] < pivotal) {
                swap(input, j, i);
                i++;
            }
        }
        swap(input, r, i+1);
        return i+1;
    }

    private int generateRandomIndex(int l, int r) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(r-l+1)+l;
    }


    private void swap(int[] input, int first, int second) {
        if (first == 0 || second == 0) {
            return;
        }

        int tmp = input[first];
        input[first] = input[second];
        input[second] = tmp;
    }
}
