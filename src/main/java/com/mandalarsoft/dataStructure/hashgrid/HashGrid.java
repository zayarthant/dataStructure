package com.mandalarsoft.dataStructure.hashgrid;

import com.mandalarsoft.dataStructure.domain.Dictionary;

public class HashGrid<K, V> implements Dictionary<K, V> {

    private Entity<?, ?>[] table;
    private final float loadFactor;
    private int threshold;
    private int size = 0;
    private int resizeCount = 0;
    private int collisions = 0;

    public HashGrid(int size, float loadFactor) {
        this.table = new Entity<?, ?>[size];
        this.loadFactor = loadFactor;
        this.threshold = (int) (table.length * loadFactor);
    }

    public HashGrid() {
        this(11, 0.75F);
    }

    private void resizeTable() {
        Entity<?, ?>[] oldTable = this.table;
        int newCapacity = (oldTable.length * 2) + 1;
        this.table = new Entity<?, ?>[newCapacity];
        for (int i = 0; i <= oldTable.length; i++) {
            Entity<K, V> entity = (Entity<K, V>) oldTable[0];
            if (null == entity)
                return;
            addEntry(entity);
            while (null != entity.next) {
                entity = entity.next;
                addEntry(entity);
            }
        }
        this.threshold = (int) (table.length * loadFactor);
        this.resizeCount++;
    }

    private V addEntry(Entity<K, V> newEntity) {
        int location = (newEntity.key.hashCode() & 0x7FFFFFFF) % table.length;
        if (table[location] == null) {
            table[location] = newEntity;
        } else {
            Entity<K, V> entity = (Entity<K, V>) table[location];
            do {
                if (entity.key.equals(newEntity.key)) {
                    V oldValue = entity.value;
                    entity.value = newEntity.value;
                    return oldValue;
                }
                if (null == entity.next)
                    break;
                entity = entity.next;
            } while (null != entity);
            entity.next = newEntity;
            collisions++;
        }
        return null;
    }

    private V addEntry(K key, V value) {
        return addEntry(new Entity<>(key, value));
    }

    @Override
    public V put(K key, V value) {
        if (size > threshold) {
            resizeTable();
        }
        V oldValue = this.addEntry(key, value);
        if (null == oldValue)
            size++;
        return oldValue;
    }

    @Override
    public V get(K key) {
        int location = (key.hashCode() & 0x7FFFFFFF) % table.length;
        if (table[location] == null)
            return null;
        Entity<K, V> entity = (Entity<K, V>) table[location];
        do {
            if (entity.key == key)
                return entity.value;
            entity = entity.next;
        } while (null != entity);
        return null;
    }


    @Override
    public V remove(K key) {
        int location = (key.hashCode() & 0x7FFFFFFF) % table.length;
        if (table[location] == null)
            return null;
        Entity<K, V> entity = (Entity<K, V>) table[location];
        if (entity.key.equals(key)) {
            table[location] = entity.next;
            size--;
            return entity.value;
        }
        while (null != entity.next) {
            if (entity.next.key.equals(key)) {
                size--;
                V value = entity.next.value;
                entity.next = entity.next.next;
                return value;
            }
            entity = entity.next;
        }
        return null;
    }

    @Override
    public void clear() {
        this.table = new Entity<?, ?>[size];
        this.size = 0;
        this.collisions = 0;
    }

    public float loadFactor() {
        return loadFactor;
    }

    public int size() {
        return size;
    }

    public int resize() {
        return resizeCount;
    }

    public int collisions() {
        return collisions;
    }
}
