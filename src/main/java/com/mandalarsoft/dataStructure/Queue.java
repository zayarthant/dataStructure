package com.mandalarsoft.dataStructure;

import com.mandalarsoft.dataStructure.list.ChainedList;
import com.mandalarsoft.dataStructure.list.chainedList.ListNode;

interface IQueue<E> {

    void enqueue(E item);

    E dequeue();

    E front();
}

public class Queue<E> extends ChainedList<E> implements IQueue<E> {

    @Override
    public void enqueue(E item) {
        add(item);
    }

    @Override
    public E dequeue() {
        E data = null;
        if (head.isPresent()) {
            ListNode<E> node = head.get();
            data = node.getData();
            head = node.next();
        }
        return data;
    }

    @Override
    public E front() {
        return head.orElse(null).getData();
    }
}
