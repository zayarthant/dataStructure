package com.mandalarsoft.dataStructure.domain;

import com.mandalarsoft.dataStructure.Entry;

public interface PriorityQueue<K, V> {
    void insert(K key, V vale);

    V min();

    V removeMin();

    int size();

    boolean isEmpty();
}
