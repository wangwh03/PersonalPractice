package com.weihua.careercup.chapter11;

public class ModifiedBS {
    public static void main(String[] args) {
        ModifiedBS binerySearch = new ModifiedBS();
        int[] num = {};
        System.out.println(binerySearch.findNumber(num, 1));
        
        int[] num2 = {1,1,1,1};
        System.out.println(binerySearch.findNumber(num2, 1));
        
        int[] num3 = {1,2,3,4,5};
        System.out.println(binerySearch.findNumber(num3, 1));
        
        int[] num4 = {3,4,5,1,2};
        System.out.println(binerySearch.findNumber(num4, 1));
        
        int[] num5 = {2,2,2,3,4,2};
        System.out.println(binerySearch.findNumber(num5, 3));
        
    }
    
    public int findNumber(int[] num, int number) {
        return findNumber(num, 0, num.length-1, number);
    }
    
    private int findNumber(int[] num, int left, int right, int number) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) /2;
        if (number == num[middle]) {
            return middle;
        } 
        if (num[left] < num[middle]) {
            if (number >= num[left] && number < num[middle]) {
                return findNumber(num, left, middle-1, number);
            } else {
                return findNumber(num, middle+1, right, number);
            }
        } else if (num[left] > num[middle]) {
            if (number >= num[middle] && number < num[right]) {
                return findNumber(num, middle+1, right, number);
            } else {
                return findNumber(num, left, middle-1, number);
            }
        } else {
            // Note: pay attention to this part when middle = left, 2,2,2,2,2,3,4
            if (num[middle] != num[right]) {
                return findNumber(num, middle+1, right, number);
            } else {
                int result = findNumber(num, left, middle-1, number);
                if (result == -1) {
                    return findNumber(num, middle+1, right, number);
                } else {
                    return result;
                }
            }
        }
    }
    
}
