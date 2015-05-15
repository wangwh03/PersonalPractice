package com.weihua.careercup.chapter3;

import java.util.Stack;

public class AscendSortStack {
    
    public static void main(String[] args) {
        Stack<Integer> testStack1 = new Stack<Integer>();
        testStack1.push(1);
        testStack1.push(3);
        testStack1.push(2);
        StackUtil.printStack(testStack1);
        
        Stack<Integer> sortedStack = AscendSortStack.sortStack(testStack1);
        StackUtil.printStack(sortedStack);
    }

    public static Stack<Integer> sortStack(Stack<Integer> originalStack) {
        Stack<Integer> sortedStack = new Stack<Integer>();
        while(!originalStack.isEmpty()) {
            int currentElement = originalStack.pop();
            if (sortedStack.isEmpty() || currentElement > sortedStack.peek()) {
                sortedStack.push(currentElement);
            } else {
                while (!sortedStack.isEmpty() && sortedStack.peek() > currentElement) {
                    originalStack.push(sortedStack.pop());
                }
                sortedStack.push(currentElement);
            }
        }
        
        return sortedStack;
    }
}
