package com.mandalarsoft.dataStructure.domain;

public interface Dictionary<K, V> {

    V get(K key);

    V put(K key, V value);

    V remove(K key);

    void clear();
}
