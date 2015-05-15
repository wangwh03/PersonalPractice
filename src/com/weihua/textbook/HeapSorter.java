package com.weihua.textbook;

public class HeapSorter<T extends Comparable<T>> {

    
    public void sort(T[] input) {
        T[] maxHeap = createMaxHeap(input);
        switchElements(maxHeap, 0, maxHeap.length-1);
        maxHeapify(maxHeap, 0, maxHeap.length-1);
    }
    
    public T[] createMaxHeap(T[] input) {
        for (int i = input.length/2; i >=0; i++) {
            maxHeapify(input, i, input.length);
        }
        
        return input;
    }
    
    public void switchElements(T[] maxHeap, int firstIndex, int secondIndex) {
        T tmp = maxHeap[firstIndex];
        maxHeap[firstIndex] = maxHeap[secondIndex];
        maxHeap[secondIndex] = tmp;
    }
    
    public void maxHeapify(T[] maxHeap, int index, int size) {
    }
}
