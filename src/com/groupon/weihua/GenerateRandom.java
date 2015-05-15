package com.groupon.weihua;
import java.util.Random;


public class GenerateRandom {

    private Random random = new Random();
    
    public static void main(String[] args) {
        GenerateRandom generateRandom = new GenerateRandom();
        generateRandom.getMegaMillion();
        generateRandom.getPowerBow();
        generateRandom.getLeto();
    }
    
    private void getMegaMillion() {
        System.out.println("Mega Million:");
        for (int i = 0; i < 5; i++) {
            System.out.print((random.nextInt(75)+1) + " ");
        }
        System.out.print(random.nextInt(15) + 1);
        System.out.println();
    }
    
    private void getPowerBow() {
        System.out.println("Power Bow:");
        for (int i = 0; i < 5; i++) {
            System.out.print((random.nextInt(59)+1) + " ");
        }
        System.out.print(random.nextInt(35) + 1);
        System.out.println();
    }
    
    private void getLeto() {
        System.out.println("Leto:");
        for (int i = 0; i < 6; i++) {
            System.out.print((random.nextInt(52)+1) + " ");
        }
        System.out.println();
    }
}
