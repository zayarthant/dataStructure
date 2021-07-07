package com.mandalarsoft.dataStructure.priorityQueue;

import com.mandalarsoft.dataStructure.Entry;
import com.mandalarsoft.dataStructure.domain.PriorityQueue;
import com.mandalarsoft.dataStructure.list.ArrayList;

public class HeapPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {


    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.add(i, heap.get(j));
        heap.add(j, temp);
    }

    protected void upHeap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j).key(), heap.get(p).key()) >= 0)
                break;
            swap(j, p);
            j = p;
        }
    }

    protected void downHeap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex).key(), heap.get(rightIndex).key()) > 0)
                    smallChildIndex = rightIndex;
            }
            if (compare(heap.get(smallChildIndex).key(), heap.get(j).key()) >= 0)
                break;
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    protected int compare(K a, K b) throws ClassCastException {
        return a.compareTo(b);
    }

    @Override
    public void insert(K key, V vale) {
        Entry<K, V> entry = new Entry<>(key, vale);
        heap.add(entry);
        upHeap(size() - 1);
    }

    @Override
    public V min() {
        if (heap.isEmpty()) return null;
        return heap.get(0).value();
    }

    @Override
    public V removeMin() {
        if (heap.isEmpty())
            return null;
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return answer.value();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
