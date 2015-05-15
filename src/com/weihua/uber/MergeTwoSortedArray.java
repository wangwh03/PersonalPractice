package com.weihua.uber;

// Merge array b into array a, assume a is large enought to hold b
public class MergeTwoSortedArray {

    public static void main(String[] args) {
        MergeTwoSortedArray test = new MergeTwoSortedArray();
        
        int[] dest = new int[5];
        int[] origin = {1,2,3};
        test.merge(dest, 0, origin,3);
        test.printArray(dest);
        
        dest[0] = 1;
        test.merge(dest, 1,origin,3);
        test.printArray(dest);

        dest[1] = 5;
        test.merge(dest, 2, origin,3);
        test.printArray(dest);

    }
    
    // No extra memory, start from the end, merge and pick the lowest
    public void merge(int[] destination, int dlength, int[] origin, int originLength) {
        if (origin.length + dlength > destination.length) {
            throw new IllegalArgumentException("First array is not large enough!");
        }

        int destIndex = dlength-1;
        int originIndex = originLength - 1;
        int resultIndex = dlength + originLength - 1;
        
        while (destIndex >= 0 && originIndex >= 0) {
            if (destination[destIndex] > origin[originIndex]) {
                destination[resultIndex] = destination[destIndex];
                destIndex--;
            } else {
                destination[resultIndex] = origin[originIndex];
                originIndex--;
            }
            resultIndex--;
        }
        
        while (originIndex >= 0) {
            destination[resultIndex] = origin[originIndex];
            originIndex--;
            resultIndex--;
        }
    }
    
    public void printArray(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + "\t");
        }
        System.out.println();
    }
}
