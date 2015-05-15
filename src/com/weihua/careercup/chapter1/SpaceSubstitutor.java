package com.weihua.careercup.chapter1;

public class SpaceSubstitutor {

    public static final String NEW_DELIMITOR = "%20";
    
    public static void main(String[] args) {
        SpaceSubstitutor spaceSubstitutor = new SpaceSubstitutor();
        System.out.println(spaceSubstitutor.substitue(null));
        System.out.println(spaceSubstitutor.substitue(""));
        System.out.println(spaceSubstitutor.substitue("a"));
        System.out.println(spaceSubstitutor.substitue(" "));
        System.out.println(spaceSubstitutor.substitue("  "));
        System.out.println(spaceSubstitutor.substitue("This is a test"));
        System.out.println(spaceSubstitutor.substitue("This is a test with space at the end   "));
    }
    
    public String substitue(String input) {
        if (input == null) {
            return input;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                stringBuilder.append(NEW_DELIMITOR);
            } else {
                stringBuilder.append(input.charAt(i));
            }
        }
        return stringBuilder.toString().trim();
    }
}
