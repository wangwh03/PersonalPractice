package com.weihua.careercup.chapter3;

// Move from a to b via c
public class HanoiTower {

    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.move(0, "A", "B", "C");
        System.out.println();
        hanoiTower.move(1, "A", "B", "C");
        System.out.println();
        hanoiTower.move(3, "A", "B", "C");
        System.out.println();
        
        Tower original = new Tower("A");
        original.addPlate(3);
        original.addPlate(2);
        original.addPlate(1);
        
        Tower destination = new Tower("B");
        Tower buffer = new Tower("C");
        
        hanoiTower.move2(3, original, destination, buffer);
    }
    
    public void move(int n, String original, String destination, String buffer) {
        if (n <= 0) {
            return;
        }
        
        move(n-1, original, buffer, destination);
        System.out.println(original + " -> " + destination);
        move(n-1, buffer, destination, original);
    }
    
    public void move2(int n, Tower original, Tower destination, Tower buffer) {
        if (n <= 0) {
            return;
        }
        
        move2(n-1, original, buffer, destination);
        int lastElement = original.getPlate();
        destination.addPlate(lastElement);
        System.out.println("Move disk " + lastElement + " from " + original.getTowerName() + " to " + destination.getTowerName());
        move2(n-1, buffer, destination, original);
    }
}
