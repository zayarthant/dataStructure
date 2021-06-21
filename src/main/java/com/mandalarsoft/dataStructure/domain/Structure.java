package com.mandalarsoft.dataStructure.domain;

public interface Structure<E> {

    int size();

    boolean isEmpty();

    boolean add(E e);

    E remove(E e);

    void clear();
}
