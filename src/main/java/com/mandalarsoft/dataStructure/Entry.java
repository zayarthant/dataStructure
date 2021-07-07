package com.mandalarsoft.dataStructure;

public class Entry<K, V> {
    private K key;
    private V value;

    public Entry() {

    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K key() {
        return key;
    }

    public void key(K key) {
        this.key = key;
    }

    public V value() {
        return value;
    }

    public void value(V value) {
        this.value = value;
    }
}
