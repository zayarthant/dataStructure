package com.mandalarsoft.dataStructure.domain;

public interface Listing<E> extends Structure<E> {

    boolean add(int index, E e);

    boolean put(int index, E e);

    E get(int index);

    E remove(int index);

    int size();

    void clear();
}
