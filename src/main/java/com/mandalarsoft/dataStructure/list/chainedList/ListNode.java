package com.mandalarsoft.dataStructure.list.chainedList;

import java.util.Optional;

public class ListNode<E> {
    private E data;
    private Optional<ListNode<E>> prev = Optional.empty();
    private Optional<ListNode<E>> next = Optional.empty();

    public ListNode(E data) {
        this.data = data;
    }

    public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
        this.data = data;
        this.next = Optional.of(next);
        this.prev = Optional.of(prev);
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Optional<ListNode<E>> next() {
        return next;
    }

    public void next(ListNode<E> next) {
        this.next = Optional.ofNullable(next);
    }

    public Optional<ListNode<E>> prev() {
        return prev;
    }

    public void prev(ListNode<E> prev) {
        this.prev = Optional.ofNullable(prev);
    }
}
