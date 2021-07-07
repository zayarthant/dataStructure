package com.mandalarsoft.dataStructure.tree;

import com.mandalarsoft.dataStructure.domain.Listing;
import com.mandalarsoft.dataStructure.list.ArrayList;

public class TreeNode<E> {
    protected E item;
    protected TreeNode<E> parent;
    protected TreeNode<E> firstChild;
    protected int childrenCount;
    protected TreeNode<E> nextSibling;

    public E get() {
        return item;
    }

    public TreeNode<E> parent() {
        return parent;
    }

    public TreeNode<E> firstChild() {
        return firstChild;
    }

    public TreeNode<E> nextSibling() {
        return nextSibling;
    }

    public boolean isRoot() {
        return null == parent;
    }

    public int children() {
        return childrenCount;
    }

    public Listing<E> getChildren() {
        ArrayList<E> arrayList = new ArrayList<>();
        if (null == firstChild)
            return arrayList;
        TreeNode<E> node = firstChild;
        do {
            arrayList.add(node.get());
            node = node.nextSibling;
        } while (null != node);
        return arrayList;
    }

    public Listing<E> getSiblings() throws IllegalAccessException{
        ArrayList<E> arrayList = new ArrayList<>();
        if(null == parent)
            throw new IllegalAccessException("Parent don't have any sibling.");
        TreeNode<E> node = parent.firstChild;
        do {
            arrayList.add(node.get());
            node = node.nextSibling;
        } while (null != node);
        return arrayList;
    }

}
