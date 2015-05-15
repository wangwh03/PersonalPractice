package com.weihua.careercup.chapter3;

public class MinStackTest {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
        System.out.println(minStack);

        minStack.push(0);
        System.out.println(minStack.getMin());
        
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack);
        
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack);
    }
}
