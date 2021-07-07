package com.mandalarsoft.dataStructure.tree;

import com.mandalarsoft.dataStructure.domain.Tree;

public abstract class AbstractTree<E> implements Tree<E> {

    protected E root;
    protected int size;

    @Override
    public E root() {
        return root;
    }

    @Override
    public boolean isRoot(E p) throws IllegalArgumentException {
        return this.root.equals(p);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size < 1;
    }
}
