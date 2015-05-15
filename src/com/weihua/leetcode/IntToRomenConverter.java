package com.weihua.leetcode;

// Convert int to romen numerel.
// Some people add 4,9 into bases as well. A lot easier than just using 1, 5, 10.
public class IntToRomenConverter {

    public static void main(String[] args) {
        IntToRomenConverter converter = new IntToRomenConverter();
        System.out.println(converter.convert(0));
        System.out.println(converter.convert(1));
        System.out.println(converter.convert(2));
        System.out.println(converter.convert(3));
        System.out.println(converter.convert(4));
        System.out.println(converter.convert(5));
        System.out.println(converter.convert(6));
        System.out.println(converter.convert(7));
        System.out.println(converter.convert(8));
        System.out.println(converter.convert(9));
        System.out.println(converter.convert(10));
        System.out.println(converter.convert(11));
        System.out.println(converter.convert(14));
        System.out.println(converter.convert(15));
        System.out.println(converter.convert(16));
        System.out.println(converter.convert(19));
        System.out.println(converter.convert(20));
        System.out.println(converter.convert(21));
        System.out.println(converter.convert(3999));
        System.out.println(converter.convert(4000));
    }
    
    public String convert(int n) {
        if (n <= 0 || n > 3999) {
            return "";
        }
        
        BaseNumber[] baseNumbers = createBaseNumbers();
        
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < baseNumbers.length; i++) {
            int base = baseNumbers[i].key;
            if (n / base >= 1) {
                for (int j = 0; j < n /base; j++) {
                    stringBuilder.append(baseNumbers[i].symbol);
                }
                n = n - base*(n/base);
            } 
        }
        
        return stringBuilder.toString();
    }

    // Can use a linked hashmap instead
    private BaseNumber[] createBaseNumbers() {
        BaseNumber[] baseNumbers = new BaseNumber[13];
        baseNumbers[0] = new BaseNumber(1000, "M");
        baseNumbers[1] = new BaseNumber(900, "CM");
        baseNumbers[2] = new BaseNumber(500, "D");
        baseNumbers[3] = new BaseNumber(400, "CD");
        baseNumbers[4] = new BaseNumber(100, "C");
        baseNumbers[5] = new BaseNumber(90, "XC");
        baseNumbers[6] = new BaseNumber(50, "L");
        baseNumbers[7] = new BaseNumber(40, "XL");
        baseNumbers[8] = new BaseNumber(10, "X");
        baseNumbers[9] = new BaseNumber(9, "IX");
        baseNumbers[10] = new BaseNumber(5, "V");
        baseNumbers[11] = new BaseNumber(4, "IV");
        baseNumbers[12] = new BaseNumber(1, "I");
        return baseNumbers;
    }

    public class BaseNumber {
        int key;
        String symbol;
        
        public BaseNumber(int key, String symbol) {
            this.key = key;
            this.symbol = symbol;
        }
    }
}
