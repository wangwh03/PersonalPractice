package com.weihua.careercup.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AnagramSorter {

    public static void main(String[] args) {
        AnagramSorter sorter = new AnagramSorter();
        String[] input = {};
        sorter.printArray(sorter.sort(input));
        
        String[] input2 = {"abc", "def", "acb"};
        sorter.printArray(sorter.sort(input2));

        String[] input3 = {"", "", "acb"};
        sorter.printArray(sorter.sort(input3));
    }
    
    public String[] sort(String[] input) {
        if(input == null) {
            return null;
        }
        HashMap<String, ArrayList<Integer>> sortedStringToIndex = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < input.length; i++) {
            char[] chars = input[i].toCharArray();
            Arrays.sort(chars);
            String sortedInput = new String(chars);
            if (sortedStringToIndex.containsKey(sortedInput)) {
                sortedStringToIndex.get(sortedInput).add(i);
            } else {
                ArrayList<Integer> indexes = new ArrayList<Integer>();
                indexes.add(i);
                sortedStringToIndex.put(sortedInput, indexes);
            }
        }
        
        String[] result = new String[input.length];
        int i = 0;
        for (ArrayList<Integer> indexes : sortedStringToIndex.values()) {
            for (Integer index : indexes) {
                result[i] = input[index];
                i++;
            }
        }
        return result;
    }
    
    private void printArray(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + "\t");
        }
        System.out.println();
    }
}
