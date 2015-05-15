package com.weihua.careercup.chapter9;


public class Parentheses {

    public static void main(String[] args) {
        Parentheses test = new Parentheses();
        test.printParentheses(0);
        test.printParentheses(1);
        test.printParentheses(2);
        test.printParentheses(3);
    }
    
    public void printParentheses(int n) {
        recursion(n, n, "");
    }
    
    private void recursion(int availableLeftCount, int availableRightCount, String currentString) {
        if (availableLeftCount == 0 && availableRightCount == 0) {
            System.out.println(currentString);
        } else if (availableLeftCount == 0 && availableRightCount > 0) {
            recursion(availableLeftCount, availableRightCount-1, currentString+")");
        } else if (availableLeftCount == availableRightCount && availableLeftCount > 0) {
            recursion(availableLeftCount-1, availableRightCount, currentString+"(");
        } else if (availableLeftCount < availableRightCount && availableLeftCount > 0) {
            recursion(availableLeftCount-1, availableRightCount, currentString+"(");
            recursion(availableLeftCount, availableRightCount-1, currentString+")");
        } 
    }
}
