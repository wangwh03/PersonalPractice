package com.weihua.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public static void main(String[] args) {
        BullsAndCows tester = new BullsAndCows();
//        System.out.println(tester.getHint("1234", "1234"));
//        System.out.println(tester.getHint("1221", "1234"));
//        System.out.println(tester.getHint("1234", "1111"));
//        System.out.println(tester.getHint("1234", "4444"));
//        System.out.println(tester.getHint("1234", "4321"));
        System.out.println(tester.getHint("11", "11"));
    }

    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) {
            return "0A0B";
        }

        if (secret.length() != guess.length()) {
            throw new IllegalArgumentException("invalid length of secret guess");
        }
        Map<Character, Integer> matchedFrequency = new HashMap<>();
        Map<Character, Integer> secretFrequency = new HashMap<>();
        Map<Character, Integer> guessFrequency = new HashMap<>();
        int counterA = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                counterA++;
                if (matchedFrequency.containsKey(secret.charAt(i))) {
                    matchedFrequency.put(secret.charAt(i), matchedFrequency.get(secret.charAt(i)) + 1);
                } else {
                    matchedFrequency.put(secret.charAt(i), 1);
                }
            }
            if (secretFrequency.containsKey(secret.charAt(i))) {
                secretFrequency.put(secret.charAt(i), secretFrequency.get(secret.charAt(i)) + 1);
            } else {
                secretFrequency.put(secret.charAt(i), 1);
            }

            if (guessFrequency.containsKey(guess.charAt(i))) {
                guessFrequency.put(guess.charAt(i), guessFrequency.get(guess.charAt(i)) + 1);
            } else {
                guessFrequency.put(guess.charAt(i), 1);
            }
        }

        int counterB = 0;
        for (Map.Entry<Character, Integer> frequency : guessFrequency.entrySet()) {
            if (secretFrequency.containsKey(frequency.getKey())) {
                counterB += Math.min(frequency.getValue(), secretFrequency.get(frequency.getKey())) -
                        (matchedFrequency.containsKey(frequency.getKey()) ? matchedFrequency.get(frequency.getKey()) : 0);
            }
        }

        return counterA + "A" + counterB + "B";
    }
}
