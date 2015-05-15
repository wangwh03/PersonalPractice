package com.weihua.careercup.chapter10.largescale;

import java.util.BitSet;

public class DupPrinter {

    public static void main(String[] args) {
        DupPrinter test = new DupPrinter();
        int[] numbers = {1,2,3,1,2,3};
        test.print(numbers);
    }
    
    public void print(int[] integers) {
        BitSet exist = new BitSet(32000);
        for (int i = 0; i < integers.length; i++) {
            if (!exist.get(integers[i])) {
                exist.set(integers[i], true);
            } else {
                System.out.println(integers[i]);
            }
        }
    }

    //    public class BitSet {
    //        int[] bitset;
    //        
    //        public BitSet(int size) {
    //            bitset = new int[size >> 5];
    //        }
    //        
    //        public boolean get(int pos) {
    //            return (bitset[pos/32] & (1 << (pos % 32))) != 0;
    //        }
    //        
    //        public void set(int pos) {
    //            bitset[pos/32] = bitset[pos/32] | (1 << (pst % 32));
    //        }
    //    }
}
