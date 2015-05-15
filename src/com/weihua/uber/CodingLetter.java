package com.weihua.uber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 1->A, 2->B, 26->BE or Z 
public class CodingLetter {

    public static void main(String[] args) {
        CodingLetter test = new CodingLetter();
                System.out.println(test.decode(1));
                System.out.println(test.decode(12));
        System.out.println(test.decode(26));
                System.out.println(test.decode(38));
                System.out.println(test.decode(1234554321));
    }

    public int encode(char input) {
        if (input >= 'A' && input <= 'Z') {
            return input -'A' + 1;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public Set<String> decode(int input) {
        HashMap<Integer, Set<String>> cache = new HashMap<Integer, Set<String>>();
        return decode(input, cache);
    }

    private Set<String> decode(int input, HashMap<Integer, Set<String>> cache) {
        if (cache.containsKey(input)) {
            return cache.get(input);
        }

        Set<String> results = new HashSet<String>();
        if (input == 0) {
            return results;
        } else if (input <= 10) {
            results.add(String.valueOf(decodeSingleChar(input)));
            return results;
        }

        int lastDigit = input % 10;
        char lastChar = decodeSingleChar(lastDigit);
        Set<String> subResults = decode(input / 10, cache);
        if (subResults.isEmpty()) {
            results.add(String.valueOf(lastChar));
        } else {
            for (String subResult : subResults) {
                results.add(subResult + lastChar);
            }
        }

        int lastTwoDigits = input % 100;
        if (lastTwoDigits <=26 && lastTwoDigits >= 1) {
            lastChar = decodeSingleChar(lastTwoDigits);
            subResults = decode(input / 100, cache);
            if (subResults.isEmpty()) {
                results.add(String.valueOf(lastChar));
            } else {
                for (String subResult : subResults) {
                    results.add(subResult + lastChar);
                }
            }
        }
        cache.put(input, results);
        return results;
    }

    private char decodeSingleChar(int input) {
        if (input >=1 && input <=26) {
            return (char) ((input - 1) + 'A');
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

}
