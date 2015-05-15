package com.weihua.uber;

import java.util.ArrayList;
import java.util.List;


public class ListTester {

    public static void main(String[] args) {
        List<String> test = new ArrayList<String>();
        test.add("a");
        test.add("b");
        test.add("c");

        List<String> test2 = test;
        test2.remove(0);
        
        List<String> test3 = new ArrayList<String>(test2);
        test3.remove(0);
        System.out.println(test2);
        System.out.println(test3);
        
        test3.set(0, "abcd");
        System.out.println(test2);
        System.out.println(test3);
    }

}
