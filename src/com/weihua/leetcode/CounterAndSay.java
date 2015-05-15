package com.weihua.leetcode;

// Given a sequence numbers, starting from 1, count and say
// For example, 1 -> 11
// 11 -> 21, 21-> 1211, 1211-> 111221, keep going
// find nth number in this sequence
public class CounterAndSay {

    public static void main(String[] args) {
        CounterAndSay test = new CounterAndSay();
//        System.out.println(test.countAndSay(-1));
//        System.out.println(test.countAndSay(0));
//        System.out.println(test.countAndSay(1));
//        System.out.println();
        System.out.println(test.countAndSay(2));
        System.out.println(test.countAndSay(3));
        System.out.println(test.countAndSay(4));
        System.out.println(test.countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String result = "1";
        if (n == 1) {
            return result;
        }

        for (int i = 2; i <= n; i++) {
            int counter = 1;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < result.length()-1; j++) {
                if (result.charAt(j) == result.charAt(j+1)) {
                    counter++;
                } else {
                    stringBuilder.append(counter).append(result.charAt(j));
                    counter = 1;
                }
            }
            stringBuilder.append(counter).append(result.charAt(result.length()-1));
            result = stringBuilder.toString();
        }
        return result;
    }
}
