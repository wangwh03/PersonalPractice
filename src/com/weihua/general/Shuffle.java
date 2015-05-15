package com.weihua.general;

import java.util.Random;

// http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm
public class Shuffle {

    public static void main(String[] args) {
        Shuffle test = new Shuffle();
        int[] input = {1,2,3,4,5,6};
        for (int i = 0; i < 10; i++) {
            test.shuffle(input);
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[j]+"\t");
            }
            System.out.println();
        }
    }
    
    public void shuffle(int[] input) {
        Random random = new Random();
        for (int i = input.length-1; i >= 1; i--) {
            int j = random.nextInt(i+1);
            exchange(input, i, j);
        }
    }
    
    private void exchange(int[] input, int l, int r) {
        int tmp = input[l];
        input[l] = input[r];
        input[r] = tmp;
    }
}
