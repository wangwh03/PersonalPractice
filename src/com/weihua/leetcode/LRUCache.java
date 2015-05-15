package com.weihua.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

// Note:  LRU means the last time of an item getting visited is the oldest should be get ridden.
// LRU does not mean frequency/count least should be removed.
// Note: priority insert/delete are all O(lgn)
public class LRUCache {
    private HashMap<Integer, Item> keyToValue = new HashMap<Integer, Item>();
    private PriorityQueue<Item> priority = new PriorityQueue<Item>(new AgetComparator());
    private int capacity;
    private long clock = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity; 
    }
    
    public int get(int key) {
        if (keyToValue.containsKey(key)) {
            Item item = keyToValue.get(key);
            priority.remove(item);
            item.setAge(clock++);
            priority.offer(item);
            return item.getValue();
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (!keyToValue.containsKey(key) && keyToValue.size() >= capacity) {
            removeLeastFrequentItem();
        }
        Item newItem = new Item(value, clock++);
        keyToValue.put(key, newItem);
        priority.add(newItem);
    }
    
    private void removeLeastFrequentItem() {
        Item leastFrequentItem = priority.poll();
        keyToValue.remove(leastFrequentItem.getValue());
    }
    
    public class Item {
        private int value;
        private long age;
        
        public Item(int key, long age) {
            this.value = key;
            this.age = age;
        }
        
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public long getAge() {
            return age;
        }
        public void setAge(long age) {
            this.age = age;
        }
        
    }
    
    public class AgetComparator implements Comparator<Item> {
        public int compare(Item f1, Item f2) {
            if (f1.getAge() > f2.getAge()) {
                return -1;
            } else if (f1.getAge() < f2.getAge()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
