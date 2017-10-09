package com.weihua.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDecoder {
    private static final Map<Integer, List<Character>> INTEGER_TO_CHARS = new HashMap<>();
    static {
        List<Character> chars = new ArrayList<>();
        INTEGER_TO_CHARS.put(1, chars);

        chars = new ArrayList<>();
        chars.add('a');
        chars.add('b');
        chars.add('c');
        INTEGER_TO_CHARS.put(2, chars);

        chars = new ArrayList<>();
        chars.add('d');
        chars.add('e');
        chars.add('f');
        INTEGER_TO_CHARS.put(3, chars);

        chars = new ArrayList<>();
        chars.add('g');
        chars.add('h');
        chars.add('i');
        INTEGER_TO_CHARS.put(4, chars);

        chars = new ArrayList<>();
        chars.add('j');
        chars.add('k');
        chars.add('l');
        INTEGER_TO_CHARS.put(5, chars);

        chars = new ArrayList<>();
        chars.add('m');
        chars.add('n');
        chars.add('o');
        INTEGER_TO_CHARS.put(6, chars);

        chars = new ArrayList<>();
        chars.add('p');
        chars.add('q');
        chars.add('r');
        chars.add('s');
        INTEGER_TO_CHARS.put(7, chars);

        chars = new ArrayList<>();
        chars.add('t');
        chars.add('u');
        chars.add('v');
        INTEGER_TO_CHARS.put(8, chars);

        chars = new ArrayList<>();
        chars.add('w');
        chars.add('x');
        chars.add('y');
        chars.add('z');
        INTEGER_TO_CHARS.put(9, chars);

        chars = new ArrayList<>();
        chars.add(' ');
        INTEGER_TO_CHARS.put(0, chars);
    }

    public static final void main(String[] args) {

        TelephoneDecoder test = new TelephoneDecoder();
//        System.out.println(test.letterCombinations(null));
//        System.out.println(test.letterCombinations(""));
//        System.out.println(test.letterCombinations("1"));
        System.out.println(test.letterCombinations("12"));
        System.out.println(test.letterCombinations("234"));
        System.out.println(test.letterCombinations("789"));
        System.out.println(test.letterCombinations("7890"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        return recursiveLetterCombinations(digits);
    }

    public List<String> recursiveLetterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        List<Character> currentChars = INTEGER_TO_CHARS.get(Integer.parseInt(String.valueOf(digits.charAt(0))));
        if (digits.length() == 1) {
            for (Character currentChar : currentChars) {
                combinations.add(currentChar.toString());
            }
            return combinations;
        }
        List<String> previousResults = recursiveLetterCombinations(digits.substring(1));
        if (currentChars.isEmpty()) {
            return previousResults;
        }
        for (String previousResult : previousResults) {
            for (Character currentChar : currentChars) {
                combinations.add(currentChar + previousResult);
            }
        }
        return combinations;
    }
}
