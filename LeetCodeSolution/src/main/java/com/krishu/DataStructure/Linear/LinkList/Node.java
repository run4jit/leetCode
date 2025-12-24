package com.krishu.DataStructure.Linear.LinkList;

public class Node<T> {
    public Node<T> next;
    private final T data;
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    public T getData() {
        return this.data;
    }
    public boolean hasNext() {
        return this.next != null;
    }

}
