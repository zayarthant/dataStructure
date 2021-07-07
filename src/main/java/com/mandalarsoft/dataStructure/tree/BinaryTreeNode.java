package com.mandalarsoft.dataStructure.tree;

public class BinaryTreeNode<E> {
    protected E item;
    protected BinaryTreeNode<E> parent;
    protected BinaryTreeNode<E> left;
    protected BinaryTreeNode<E> right;
    protected TreeNode<E> sibling;

    public E get() {
        return item;
    }

    public BinaryTreeNode<E> parent() {
        return parent;
    }

    public BinaryTreeNode<E> left() {
        return left;
    }

    public BinaryTreeNode<E> right() {
        return right;
    }

    public TreeNode<E> sibling() {
        return sibling;
    }
}
