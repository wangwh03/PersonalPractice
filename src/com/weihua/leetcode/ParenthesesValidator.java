package com.weihua.leetcode;

import java.util.Stack;

public class ParenthesesValidator {

    public static void main(String[] args) {
        ParenthesesValidator validator = new ParenthesesValidator();
        System.out.println(validator.isValid("["));
        System.out.println(validator.isValid("]"));
        System.out.println(validator.isValid("([])"));
        System.out.println(validator.isValid("([)]"));
    }

    public boolean isValid(String s) {
        Stack<Character> braceStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (isLeft(currentChar)) {
                braceStack.push(currentChar);
            } else if (isRight(currentChar)) {
                if (!isValid(currentChar, braceStack)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return braceStack.isEmpty();
    }

    private boolean isLeft(Character character) {
        return character == '(' ||
                character == '{' ||
                character == '[';
    }

    private boolean isRight(Character character) {
        return character == ')' ||
                character == '}' ||
                character == ']';
    }


    private boolean isValid(Character currentRightChar,
                            Stack<Character> braceStack) {
        if (braceStack.isEmpty()) {
            return false;
        }

        Character currentStackChar = braceStack.pop();
        return (currentRightChar == ')' && currentStackChar == '(') ||
                (currentRightChar == ']' && currentStackChar == '[') ||
                (currentRightChar == '}' && currentStackChar == '{');
    }
}
