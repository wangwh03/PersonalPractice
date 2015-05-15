package com.groupon.weihua;


public class TinyUrlGenerator {

    public static final String BASE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static void main(String[] args) {
        TinyUrlGenerator generator = new TinyUrlGenerator();
        try {
            String shortUrl = generator.generate(" a");
            System.out.println(shortUrl);
            System.out.println("recovered id");
            System.out.println(generator.recover(shortUrl));
        } catch (IllegalArgumentException e) {
            System.out.println("Error!");
        }
    }
    
    public String generate(String longUrl) throws IllegalArgumentException {
        StringBuilder shortUrlBuilder = new StringBuilder();
        // Insert into DB and return an long id
        long id = mockSsaveUrl(longUrl);
        System.out.println("db id is " + id);
        int mode = BASE.length();
        int reminder;
        do {
            reminder = (int) (id % mode);
            id = id / mode;
            System.out.println(reminder);
            shortUrlBuilder.append(mapNumberToChar(reminder));
        } while (id >= mode);
        shortUrlBuilder.append(mapNumberToChar((int)id));
        return shortUrlBuilder.reverse().toString();
    }
    
    private static long mockSsaveUrl(String url) {
        return Math.abs(url.hashCode());
    }
    
    private char mapNumberToChar(int number) throws IllegalArgumentException {
        if (number >= 0 && number <= 9) {
            return (char)(number + '0');
        } else if (number >= 10 && number <= 35) {
            return (char)(number - 10 + 'a');
        } else if (number >= 36 && number <= 61) {
            return (char)(number - 35 + 'A');
        } else {
            throw new IllegalArgumentException("number must be between 0 and 61!");
        }
    }
    
    public String recover(String shortUrl) throws IllegalArgumentException {
        long id = 0;
        for (int i = 0; i < shortUrl.length(); i++) {
            int currentNumber = mapCharToNumber(shortUrl.charAt(i));
            id += currentNumber * Math.pow(BASE.length(), shortUrl.length() -1 -i);
        }
        System.out.println(id);
        // Call DB to fetch long url from id
        return "";
    }
    
    private int mapCharToNumber(char input) throws IllegalArgumentException {
        if (input >= '0' && input <= '9') {
            return input - '0';
        } else if (input >= 'a' && input <= 'z') {
            return input - 'a' + 10;
        } else if (input >= 'A' && input <= 'Z') {
            return input - 'A' + 35;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }
    
}
