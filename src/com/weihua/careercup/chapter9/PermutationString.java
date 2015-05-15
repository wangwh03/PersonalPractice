package com.weihua.careercup.chapter9;

import java.util.LinkedList;
import java.util.List;

public class PermutationString {

    public static void main(String[] args) {
        System.out.println(getPermutations(null));
        System.out.println(getPermutations(""));
        System.out.println(getPermutations("a"));
        System.out.println(getPermutations("abc"));
    }
    
    public static List<String> getPermutations(String input) {
        List<String> permutations = new LinkedList<String>();
        
        if (input == null || input.length() == 0) {
            return permutations;
        }
        
        List<String> subPermutations = getPermutations(input.substring(0, input.length()-1));
        String lastChar = input.substring(input.length()-1, input.length());
        if (subPermutations.isEmpty()) {
            permutations.add(lastChar);
        } else {
            for (String subPermutation : subPermutations) {
                for (int i = 0; i < subPermutation.length() + 1; i++) {
                    permutations.add(subPermutation.substring(0, i) + lastChar + subPermutation.substring(i, subPermutation.length()));
                }
            }
        }
        return permutations;
    }
}
