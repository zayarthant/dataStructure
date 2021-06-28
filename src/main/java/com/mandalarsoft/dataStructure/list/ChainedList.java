package com.mandalarsoft.dataStructure.list;

import com.mandalarsoft.dataStructure.domain.Listing;
import com.mandalarsoft.dataStructure.list.chainedList.ListNode;

import java.util.Optional;

public class ChainedList<T> implements Listing<T> {

    private Optional<ListNode<T>> head = Optional.empty();
    private Optional<ListNode<T>> tail = Optional.empty();
    private int size;

    public ChainedList() {

    }

    @Override
    public boolean add(int index, T t) {
        if (index > this.size)
            throw new ArrayIndexOutOfBoundsException(index);
        ListNode<T> newNode = new ListNode<T>(t);
        ListNode<T> node = getNode(index);
        newNode.next(node);
        node.prev().ifPresent(n -> {
            newNode.prev(n);
            n.next(newNode);
        });
        node.prev(node);

        return true;
    }

    @Override
    public boolean put(int index, T t) {
        getNode(index).setData(t);
        return true;
    }

    @Override
    public T get(int index) {
        return getNode(index).getData();
    }

    private ListNode<T> getNode(int index) {
        if (index > this.size)
            throw new ArrayIndexOutOfBoundsException(index);
        if (index == size)
            return tail.orElse(null);

        Optional<ListNode<T>> node;
        if (index <= (size / 2)) {
            node = this.head;
            for (int i = 1; i <= index; i++)
                if (node.isPresent())
                    node = node.get().next();
        } else {
            node = this.tail;
            for (int i = index + 1; i < size; i++)
                if (node.isPresent())
                    node = node.get().prev();
        }
        return node.orElse(null);
    }

    @Override
    public T remove(int index) {
        ListNode<T> node = getNode(index);
        ListNode<T> next = node.next().orElse(null);
        node.prev().ifPresent(n -> {
            n.next(next);
            next.prev(n);
        });
        return node.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size < 1;
    }

    @Override
    public boolean add(T t) {
        ListNode<T> node = new ListNode<>(t);
        if (!head.isPresent())
            head = Optional.of(node);
        this.tail.ifPresent(n -> {
            n.next(node);
            node.prev(n);
        });
        this.tail = Optional.of(node);
        this.size++;
        return true;
    }

    @Override
    public T remove(T t) {
        return null;
    }

    @Override
    public void clear() {
        head = Optional.empty();
        tail = Optional.empty();
        size = 0;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("[");
        head.ifPresent(n -> {
            builder.append(n.getData());
            ListNode<T> node = n;
            while (node.next().isPresent()) {
                node = node.next().get();
                builder.append(", ");
                builder.append(node.getData());
            }
        });
        return builder.append("]").toString();
    }
}
