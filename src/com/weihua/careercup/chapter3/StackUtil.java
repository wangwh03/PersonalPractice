package com.weihua.careercup.chapter3;

import java.util.Stack;

public class StackUtil {

    public static void printStack(Stack stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i) + " ");
        }
        System.out.println();
    }
}
