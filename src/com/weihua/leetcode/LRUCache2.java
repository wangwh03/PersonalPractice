package com.weihua.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

// Double Linkedlist + hashset. Put the most recently visited at the beginning, and least visited at the end
// When set, if capacity is full, remove the end element, insert into the beginning.
// When visit, take the one that is getting visited, and put into the begining.
// Question: not sure when visiting, how the time complexity is O(1), since we need to search that element
public class LRUCache2 {

    private HashMap<Integer, Item> keyToValue = new HashMap<Integer, Item>();
    private int capacity;
    private LinkedList<Item> itemsOrder = new LinkedList<Item>();
 
    public int get(int key) {
        if (keyToValue.containsKey(key)) {
            Item item = keyToValue.get(key);
            itemsOrder.remove(item);
            itemsOrder.addFirst(item);
            return item.getValue();
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (!keyToValue.containsKey(key) && keyToValue.size() >= capacity) {
            itemsOrder.removeLast();
        }
        Item newItem = new Item(value, 0);
        keyToValue.put(key, newItem);
        itemsOrder.addFirst(newItem);
    }
    
    public class Item {
        private int value;
        private int frequency;
        
        public Item(int key, int frequency) {
            this.value = key;
            this.frequency = frequency;
        }
        
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public int getFrequency() {
            return frequency;
        }
        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
        
    }
}
