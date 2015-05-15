package com.weihua.uber;

import java.util.HashSet;
import java.util.Set;

// given a word lockern, and a dictionaly lock, locer, erning, check if lockern can be parsed with the word in the dictionary
public class DictionalryParse {

    public static void main(String[] args) {
        DictionalryParse parser = new DictionalryParse();
        Set<String> bases = new HashSet<String>();
        bases.add("lock");
        bases.add("locker");
        bases.add("erning");
        
        System.out.println(parser.isParsable("lockern", bases));
        System.out.println(parser.isParsable("lockerning", bases));
    }
    
    public boolean isParsable(String input, Set<String> bases) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        
        for (String base : bases) {
            boolean isInputStartWithBase = isInputStartWith(input, base);
            if (isInputStartWithBase) {
                Set<String> subBases = new HashSet<String>(bases);
                subBases.remove(base);
                boolean subResult = isParsable(input.substring(base.length(), input.length()), subBases);
                if (subResult) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isInputStartWith(String input, String base) {
        int inputLength = input.length();
        int baseLength = base.length();
        if (inputLength < baseLength) {
            return false;
        }
        for (int i = 0; i < baseLength; i++) {
            if (input.charAt(i) != base.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
