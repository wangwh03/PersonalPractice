package com.weihua.careercup.chapter3;

import java.util.Stack;

public class Tower {
    
    private Stack<Integer> plates = new Stack<Integer>();
    private String towerName;
    
    public Tower(String towerName) {
        this.towerName = towerName;
    }
    
    public Stack<Integer> getPlates() {
        return plates;
    }
    
    public Integer getPlate() {
        return plates.pop();
    }

    public void addPlate(Integer plate) {
        plates.push(plate);
    }

    public String getTowerName() {
        return towerName;
    }

}
