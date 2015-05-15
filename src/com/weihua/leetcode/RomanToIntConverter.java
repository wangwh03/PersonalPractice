package com.weihua.leetcode;

import java.util.HashMap;

public class RomanToIntConverter {
    public static void main(String[] args) {
        RomanToIntConverter converter = new RomanToIntConverter();
        System.out.println(converter.romanToInt(""));
        System.out.println(converter.romanToInt("I"));
        System.out.println(converter.romanToInt("II"));
        System.out.println(converter.romanToInt("III"));
        System.out.println(converter.romanToInt("IV"));
        System.out.println(converter.romanToInt("V"));
        System.out.println(converter.romanToInt("VI"));
        System.out.println(converter.romanToInt("VII"));
        System.out.println(converter.romanToInt("VIII"));
        System.out.println(converter.romanToInt("IX"));
        System.out.println(converter.romanToInt("X"));
        System.out.println(converter.romanToInt("MMMCCXXI"));
    }
    public HashMap<Character, Integer> charToInt = createCharToInt();

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        int i;
        for (i = 0; i < s.length()-1; i++) {
            if (charToInt.get(s.charAt(i)) >= charToInt.get(s.charAt(i+1))) {
                result += charToInt.get(s.charAt(i));
            } else {
                result += charToInt.get(s.charAt(i+1)) - charToInt.get(s.charAt(i));
                i++;
            }
        }
        if (i == s.length()-1) {
            result += charToInt.get(s.charAt(i));
        }
        return result;
    }
    
    private HashMap<Character, Integer> createCharToInt() {
        HashMap<Character, Integer> charToInt = new HashMap<Character, Integer>();
        charToInt.put('M', 1000);
        charToInt.put('D', 500);
        charToInt.put('C', 100);
        charToInt.put('L', 50);
        charToInt.put('X', 10);
        charToInt.put('V', 5);
        charToInt.put('I', 1);
        
        return charToInt;

    }
    
    
}
