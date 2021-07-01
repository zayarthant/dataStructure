package com.mandalarsoft.dataStructure.list;

import com.mandalarsoft.dataStructure.domain.Listing;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<E> implements Listing<E> {

    private static int DEFAULT_CAPACITY = 11;

    private int size;

    private E[] data;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    private ArrayList(int size) {
        this.data = (E[]) new Object[size];
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
        for (int i = size; i >= index; ) {
            i--;
            add((E) data[i], i + 1);
        }
        this.add(e, index);
        size++;
        return true;
    }

    @Override
    public boolean put(int index, E e) {
        if (index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        data[index] = e;
        return true;
    }

    @Override
    public E get(int index) {
        if (index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        return data[index];
    }

    private void add(E e, int index) {
        if (index >= data.length)
            grawCapacity();
        data[index] = e;
    }

    private void grawCapacity() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public E remove(E e) {
        return null;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public E remove(int index) {
        if (index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        E old = data[index];
        for (int i = index; i < size; i++) {
            add(data[i + 1], i);
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
