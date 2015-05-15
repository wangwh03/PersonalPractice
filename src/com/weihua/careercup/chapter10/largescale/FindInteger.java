package com.weihua.careercup.chapter10.largescale;

public class FindInteger {

    public static void main(String[] args) {
        FindInteger test = new FindInteger();
        int[][] ints = {{0,1,2,3},{4,5,6,9}};
        System.out.println(test.findNonExistingInteger(ints));
    }

    public int findNonExistingInteger(int[][] existingInts) {
        for (int partIndex = 0; partIndex < existingInts.length; partIndex++) {
            int[] ints = existingInts[partIndex];
            byte[] exists = new byte[ints.length];
            
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] < ints.length*(partIndex+1)) {
                    exists[ints[i]%ints.length] = 1;
                }
            }

            for (int i = 0; i < exists.length; i++) {
                if (exists[i] == 0) {
                    return partIndex*exists.length + i;
                }
            }
        }

        return existingInts.length* existingInts[0].length+1;
    }
}
