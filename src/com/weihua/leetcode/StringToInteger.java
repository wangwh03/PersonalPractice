package com.weihua.leetcode;

// Remember to consider overflow.  check java source code Integer.parseInt() for reference
public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger parser = new StringToInteger();
        //        System.out.println(parser.parse(null));
        //        System.out.println(parser.parse(""));
        //        System.out.println(parser.parse("  "));
        //        System.out.println(parser.parse(" a"));
//        System.out.println(parser.parse(" 1"));
//        System.out.println(parser.parse(" -1"));
//        System.out.println(parser.parse(" 2147483647"));
        System.out.println(parser.parse(" -2147483649"));
//        System.out.println(parser.parse(" 2147483648"));
//        System.out.println(parser.parse(" -2147483648"));
//        System.out.println(parser.parse(" 12abcd"));
//        System.out.println(parser.parse(" 12. "));
//        System.out.println(parser.parse(" -12. "));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(-Integer.MAX_VALUE);
//        System.out.println(-Integer.MIN_VALUE);
        // Below two throws exceptions as expected
//        System.out.println(parser.parse(" -"));
//        System.out.println(Integer.parseInt("1234567890123"));
    }

    public int parse(String s) {
        if (s == null) {
            return 0;
        }

        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        boolean negative = false;
        if (!isNumber(s.charAt(0))) {
            if (hasSign(s)) {
                if (s.length() == 1) {
                    return 0;
                }
                if (s.charAt(0) == '-') {
                    negative = true;
                } else if (s.charAt(0) != '+') {
                    return 0;
                }
            }
        }

        int result = 0;
        int index = hasSign(s) ? 1 : 0;
        int limit = negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        float lowerLimit = ((float)limit)/10;
        while (index < s.length() && isNumber(s.charAt(index))) {
            int currentDigit = convertCharToInt(s.charAt(index));
            if ((!negative && lowerLimit < result + ((float)currentDigit)/10)
                            || ((negative && lowerLimit > -result - ((float)currentDigit)/10))) {
                
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result*10 + currentDigit; 
            index++;
        }
        return negative ? -result : result;
    }

    private boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    private int convertCharToInt(char c) {
        return c - '0';
    }

    private boolean hasSign(String s) {
        return s.charAt(0) == '+' || s.charAt(0) == '-';
    }

}

