package com.mandalarsoft.dataStructure.domain;

import com.mandalarsoft.dataStructure.tree.TreeNode;

public interface Tree<E> {
    E root();

    boolean isRoot(E p) throws IllegalArgumentException;

    int size();

    boolean isEmpty();
}
