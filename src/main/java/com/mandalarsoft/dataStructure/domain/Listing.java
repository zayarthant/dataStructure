package com.mandalarsoft.dataStructure.domain;

public interface Listing<E> extends Structure<E> {
    boolean add(int index, E e);

    E remove(int index);

    int size();

    void clear();
}
