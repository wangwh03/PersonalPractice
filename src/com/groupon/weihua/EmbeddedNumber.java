package com.groupon.weihua;
import java.util.ArrayList;
import java.util.List;


public class EmbeddedNumber {

    private int sum = 0;
    public static void main(String[] args) {
        EmbeddedNumber calculator = new EmbeddedNumber();
        List<Object> input = new ArrayList<Object>();
        input.add(1);
        input.add(2);
        List<Object> list1 = new ArrayList<Object>();
        list1.add(3);
        list1.add(4);
        input.add(list1);

        List<Object> list2 = new ArrayList<Object>();
//        list2.add(5);
//        list2.add(6);
        input.add(list2);
        
        calculator.printSum(input);
    }

    private void printSum(List<Object> input) {
        recursive(input);
        System.out.println("Sum: " + sum);
    }
    
    private int recursive(List<Object> input) {
        for (Object aList : input) {
            if ( aList instanceof Integer) {
                sum += (Integer) aList;
            } else if (aList instanceof List) {
                recursive((List)aList);
            }
        }
        return sum;
    }
}
