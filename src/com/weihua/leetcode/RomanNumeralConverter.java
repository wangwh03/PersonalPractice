package com.weihua.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {
    public static void main(String[] args) {
        RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
//        System.out.println(romanNumeralConverter.convert(0));
//        System.out.println(romanNumeralConverter.convert(4000));
        System.out.println(romanNumeralConverter.convert(1));
        System.out.println(romanNumeralConverter.convert(2));
        System.out.println(romanNumeralConverter.convert(4));
        System.out.println(romanNumeralConverter.convert(5));
        System.out.println(romanNumeralConverter.convert(9));
        System.out.println(romanNumeralConverter.convert(3999));
    }

    private static Map<String, Integer> intToRoman = new LinkedHashMap<>();
    static {
        intToRoman.put("M", 1000);
        intToRoman.put("CM", 900);
        intToRoman.put("D", 500);
        intToRoman.put("CD", 400);
        intToRoman.put("C", 100);
        intToRoman.put("XC", 90);
        intToRoman.put("L", 50);
        intToRoman.put("XL", 40);
        intToRoman.put("X", 10);
        intToRoman.put("IX", 9);
        intToRoman.put("V", 5);
        intToRoman.put("IV", 4);
        intToRoman.put("I", 1);
    }

    public String convert(int input) {
        if (input < 1 || input > 3999) {
            throw new IllegalArgumentException("Input out of range");
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (String romanLetter : intToRoman.keySet()) {
            // Note: notice this optimization to cut run time
            if (input <= 0) {
                return resultBuilder.toString();
            }
            int currentUnit = intToRoman.get(romanLetter);
            int currentResult = input / currentUnit;
            if (currentResult > 0) {
                for (int i = 0; i < currentResult; i++) {
                    resultBuilder.append(romanLetter);
                }
                input = input - currentResult * currentUnit;
            }
        }

        return resultBuilder.toString();
    }
}
