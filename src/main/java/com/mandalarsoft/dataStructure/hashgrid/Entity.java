package com.mandalarsoft.dataStructure.hashgrid;

public class Entity<K, V> {
    final K key;
    V value;
    Entity<K, V> next;

    public Entity(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
