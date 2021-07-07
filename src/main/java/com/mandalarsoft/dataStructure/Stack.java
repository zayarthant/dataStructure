package com.mandalarsoft.dataStructure;

import com.mandalarsoft.dataStructure.list.chainedList.ListNode;

interface IStack<E> {
    int size();

    boolean isEmpty();

    void push(E item);

    E pop();

    E top();
}

public class Stack<E> implements IStack<E> {

    private ListNode<E> node;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size < 1;
    }

    @Override
    public void push(E item) {
        ListNode<E> newNode = new ListNode<>(item);
        newNode.next(this.node);
        this.node = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (null == node)
            return null;
        E data = node.getData();
        node = node.next().orElse(null);
        size--;
        return data;
    }

    @Override
    public E top() {
        if (null == node)
            return null;
        return node.getData();
    }
}
