package com.weihua.careercup.chapter9;

import java.util.HashSet;
import java.util.Set;

public class Subset {
    
    public static void main(String[] args) {
        Subset subset = new Subset();
        System.out.println(subset.getSubsets(null));
        
        HashSet<String> test1 = new HashSet<String>();
        System.out.println(subset.getSubsets(test1));
        
        test1.add("a");
        System.out.println(subset.getSubsets(test1));
        
        test1.add("b");
        System.out.println(subset.getSubsets(test1));
        
        test1.add("this");
        System.out.println(subset.getSubsets(test1));
        
        test1.add("is");
        System.out.println(subset.getSubsets(test1));
    }

    public HashSet<Set<String>> getSubsets(Set<String> input) {
        HashSet<Set<String>> subsets = new HashSet<Set<String>>();
        
        if (input == null) {
            return subsets;
        }
        
        for (String element : input) {
            Set<String> inputCopyWithoutElement = copySetWithoutElement(input, element);
            subsets.addAll(getSubsets(inputCopyWithoutElement));
            Set<String> singleElementSet = createSingleElementSet(element);
            subsets.add(singleElementSet);
        }
        subsets.add(input);
        
        return subsets;
    }
    
    private Set<String> copySetWithoutElement(Set<String> input, String element) {
        HashSet<String> copyOfSet = new HashSet<String>();
        for (String setElement : input) {
            if (setElement != element) {
                copyOfSet.add(setElement);
            }
        }
        
        return copyOfSet;
    }
    
    private Set<String> createSingleElementSet(String element) {
        HashSet<String> set = new HashSet<String>();
        set.add(element);
        return set;
    }
}
