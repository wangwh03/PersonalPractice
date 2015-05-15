package com.weihua.careercup.chapter1;

import java.security.InvalidAlgorithmParameterException;

public class BinaryHexComparator {

    public static void main(String[] args) {
        try {
//            System.out.println(getInteger('0'));
//            System.out.println(getInteger('9'));
//            System.out.println(getInteger('a'));
            
//            System.out.println(computeValue("0", 2));
//            System.out.println(computeValue("1", 2));
            System.out.println(computeValue("10", 2));
//            System.out.println(isEqual(null, null));
//            System.out.println(isEqual(null, "a"));
//            System.out.println(isEqual("1", null));
//            System.out.println(isEqual("", ""));
            System.out.println(isEqual("100", "4"));
            System.out.println(isEqual("1010", "a"));
            System.out.println(isEqual("110", "aa"));
            System.out.println(isEqual("1100", "aab"));
        } catch (InvalidAlgorithmParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public static boolean isEqual(String binaryNumber, String hexNumber) throws InvalidAlgorithmParameterException {
        if (binaryNumber == null || hexNumber == null) {
            if (hexNumber == null && binaryNumber == null) {
                return true;
            } else {
                return false;
            }
        } 
        
        int binaryValue = computeValue(binaryNumber, 2);
        int hexValue = computeValue(hexNumber, 16);

        return binaryValue == hexValue;
    }
    
    // Assuming int is big enought to hold the number
    protected static int computeValue(String valueRepresentation, int base) throws InvalidAlgorithmParameterException {
        if (base != 2 && base != 16) {
            throw new InvalidAlgorithmParameterException("base can be only 2 or 16");
        }
        int result = 0;
        int length = valueRepresentation.length();
        for (int i = 0; i < length; i++) {
            result += Math.pow(base, length - 1 - i) * getInteger(valueRepresentation.charAt(i));
        }
        
        return result;
    }
    
    protected static int getInteger(char input) throws InvalidAlgorithmParameterException {
        if (input >= '0' && input <= '9') {
            return input - '0';
        } else if (input >='a' && input <='f') {
            return input -'a' + 10;
        } else {
            throw new InvalidAlgorithmParameterException("Invalid char in input");
        }
    }
}
