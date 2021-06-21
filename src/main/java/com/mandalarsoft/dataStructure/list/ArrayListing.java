package com.mandalarsoft.dataStructure.list;

import com.mandalarsoft.dataStructure.domain.Listing;

import java.util.Arrays;
import java.util.Objects;

public class ArrayListing<E> implements Listing<E> {

    private static int DEFAULT_CAPACITY = 11;

    private int size;

    private Object[] data;

    public ArrayListing() {
        this(DEFAULT_CAPACITY);
    }

    private ArrayListing(int size) {
        this.data = new Object[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public boolean add(E e) {
        this.add(e, size);
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E e) {
        if (index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        for (int i = size ; i >= index; ) {
            i--;
            add((E) data[i], i + 1);
        }
        this.add(e, index);
        size++;
        return true;
    }

    private void add(E e, int index) {
        if (index >= data.length)
            grawCapacity();
        data[index] = e;
    }

    private void grawCapacity() {
        data = Arrays.copyOf(data, data.length + 11);
    }

    @Override
    public E remove(E e) {
        return null;
    }

    @Override
    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public E remove(int index) {
        if (index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        E old = (E) data[index];
        for (int i = index; i < size; i++) {
            add((E) data[i + 1], i);
        }
        size--;
        data[size] = null;
        return old;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(data).filter(Objects::nonNull).toArray());
    }
}
