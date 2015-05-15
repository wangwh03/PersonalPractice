package com.weihua.uber;

// Find longest palindrome in a string
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();
        //        System.out.println(test.getLongestalindrome(null));
        //        System.out.println(test.getLongestalindrome(""));
        //        System.out.println(test.getLongestalindrome("a"));
        //        System.out.println(test.getLongestalindrome("aba"));
//        System.out.println(test.getLongestalindrome("ababbccbb"));
//        System.out.println(test.getLongestPalindromBetterMemory(null));
//        System.out.println(test.getLongestPalindromBetterMemory(""));
//        System.out.println(test.getLongestPalindromBetterMemory("a"));
//        System.out.println(test.getLongestPalindromBetterMemory("ab"));
//        System.out.println(test.getLongestPalindromBetterMemory("aba"));
        System.out.println(test.getLongestPalindromBetterMemory("abccddeeddccba"));
    }

    // Solution 1: create a n*n table with different combination of startIndex and endIndex.  Note startIndex always <= endIndex, so only need to fill in half
    public String getLongestalindrome(String input) {

        String result = "";
        if (input == null || input.isEmpty()) {
            return result;
        }

        boolean[][] isPalin = new boolean[input.length()][input.length()];

        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            isPalin[i][i] = true;
        }

        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i) == input.charAt(i+1)) {
                isPalin[i][i+1] = true;
                startIndex = i;
                endIndex = i+1;
            }
        }

        for (int length = 3; length <= input.length(); length++) {
            for (int i = 0; i+length-1 < input.length(); i++) {
                int j = i + length - 1;
                if (input.charAt(i) == input.charAt(j) && isPalin[i+1][j-1]) {
                    isPalin[i][j] = true;
                    startIndex = i;
                    endIndex = j;
                } else {
                    isPalin[i][j] = false;
                }
            }
        }

        return input.substring(startIndex, endIndex+1);
    }

    // Solution 2: N^2 no extra N*Nmemory used.  Each palindrome expand with a center, there are 2N-1 total places as center in this string, each center
//    takes N worst to expand.
    public String getLongestPalindromBetterMemory(String input) {
        String maxPalindrom = "";
        if (input == null || input.isEmpty()) {
            return maxPalindrom;
        }

        for (int i = 0; i < input.length(); i++) {
            String longestWithLetterAsCenter = expand(input, i);
            if (longestWithLetterAsCenter.length() > maxPalindrom.length()) {
                maxPalindrom = longestWithLetterAsCenter;
            }
            
            String longestAfterLetterAsCenter = expandAfterLetter(input, i);
            if (longestAfterLetterAsCenter.length() > maxPalindrom.length()) {
                maxPalindrom = longestAfterLetterAsCenter;
            }
        }
        return maxPalindrom;
    }

    private String expand(String input, int centerIndex) {
        int left = centerIndex;
        int right = centerIndex;
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        return input.substring(left+1, right);
    };
    
    private String expandAfterLetter(String input, int centerIndex) {
        int left = centerIndex;
        int right = centerIndex+1;
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        return input.substring(left+1, right);
    };
}
