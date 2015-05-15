package com.weihua.careercup.chapter3;

import java.util.Stack;

public class MyQueue<T> {
    private Stack<T> enqueue = new Stack<T>();
    private Stack<T> dequeue = new Stack<T>();

    public static void main(String[] args) {
        MyQueue<Integer> myqueue = new MyQueue<Integer>();
        myqueue.push(1);
        myqueue.push(5);
        
        System.out.println(myqueue.pop());
        myqueue.push(3);
        myqueue.push(6);
        
        System.out.println(myqueue.pop());
        System.out.println(myqueue.pop());
        System.out.println(myqueue.pop());
    }
    
    public void push(T item) {
        enqueue.push(item);
    }
    
    public T pop() {
        if (dequeue.isEmpty()) {
            while(!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }
        
        return dequeue.pop();
    }
}

