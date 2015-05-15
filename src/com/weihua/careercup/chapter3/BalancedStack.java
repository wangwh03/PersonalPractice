package com.weihua.careercup.chapter3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BalancedStack {

    public static final int MAX_ELEMENT_NUMBER = 2;

    private List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
    private int totalStackNumber = 0;
    
    public static void main(String[] args) {
        BalancedStack balancedStack = new BalancedStack();
        balancedStack.push(0);
        System.out.println(balancedStack);
        balancedStack.push(1);
        System.out.println(balancedStack);
        balancedStack.push(2);
        System.out.println(balancedStack);
        
        balancedStack.pop();
        System.out.println(balancedStack);
        balancedStack.pop();
        System.out.println(balancedStack);
        balancedStack.pop();
    }
    
    public void push(int newValue) {
        int i = 0;
        if (stacks.isEmpty()) {
            stacks.add(new Stack<Integer>());
            totalStackNumber++;
        }
        
        while(i < totalStackNumber && stacks.get(i).size() >= MAX_ELEMENT_NUMBER) {
            i++;
        }
        
        if (i < totalStackNumber) {
            stacks.get(i).push(newValue);
        } else {
            stacks.add(new Stack<Integer>());
            totalStackNumber++;
            stacks.get(totalStackNumber-1).push(newValue);
        }
    }
    
    public int pop() {
        for (int i = 0; i < totalStackNumber - 1; i++) {
            if (stacks.get(i+1).isEmpty()) {
                return stacks.get(i).pop();
            }
        }
        return stacks.get(totalStackNumber-1).pop();
    }
    
    public String toString() {
        Iterator<Stack<Integer>> iterator = stacks.iterator();
        StringBuffer stringBuffer = new StringBuffer();
        
        int stackIndex = 1;
        while(iterator.hasNext()) {
            Stack<Integer> stack = iterator.next();
            stringBuffer.append("stack ").append(stackIndex).append(" values: ");
            for (int i = 0; i < stack.size(); i++) {
                stringBuffer.append(stack.get(i)).append(" ");
            }
            stackIndex++;
            stringBuffer.append("\n");
        }
        
        return stringBuffer.toString();
    }
}
