package com.weihua.leetcode;

import java.util.concurrent.ThreadLocalRandom;

public class TinyUrlGenerator {
    private static final String BASE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        TinyUrlGenerator generator = new TinyUrlGenerator();
        System.out.println(generator.urlShortener("deals.json?city=chicago"));
    }

    public String urlShortener(String longUrl) {
        long id = generateId();

        int mod = BASE.length();
        StringBuilder result = new StringBuilder();
        int remainder;
        while (id != 0) {
            remainder = (int) (id % mod);
            result.append(convertNumToChar(remainder));
            id = id / mod;
        }
        return result.reverse().toString();
    }

    private char convertNumToChar(int remainder) {
        if (remainder >= 0 && remainder <= 9) {
            return (char) ('0' + remainder);
        } else if (remainder >= 10 && remainder <= 36) {
            return (char) ('a' + remainder - 10);
        } else {
            return (char) ('A' + remainder - 36);
        }
    }

    private long generateId() {
        return ThreadLocalRandom.current().nextInt();
    }
}
