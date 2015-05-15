package com.weihua.careercup.chapter3;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int newElement) {
        stack.push(newElement);
        if (minStack.isEmpty() || newElement <= minStack.peek()) {
            minStack.push(newElement);
        }
    }
    
    public int pop() {
        int topElement = stack.pop();
        if (topElement == minStack.peek()) {
            minStack.pop();
        }
        return topElement;
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            stringBuilder.append(stack.get(i)).append(" ");
        }
        
        return stringBuilder.toString();
    }
}
