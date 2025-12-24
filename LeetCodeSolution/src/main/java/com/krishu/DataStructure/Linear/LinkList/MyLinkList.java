package com.krishu.DataStructure.Linear.LinkList;

public class MyLinkList<T> {
    private Node<T> head;

    public void insertAtEnd(T data) {
        Node<T> node = new Node<>(data);
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
    public void insertAtBegining(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        this.head = node;
    }
    public void insertAtIndex(int index, T data) {
        if (index == 0) {
            insertAtBegining(data);
        } else  {

            int count = 1;
            Node<T> temp = head;
            while (temp != null && count != index) {
                count++;
                temp = temp.next;
            }
            if (temp != null) {
                Node<T> node = new Node<>(data);
                Node<T> nextNode = temp.next;
                temp.next = node;
                node.next = nextNode;
            }
        }
    }

    public T getDataAt(int index) {
        int count = 0;
        Node<T> temp = head;
        while (temp != null && count != index) {
            count++;
            temp = temp.next;
        }
        if (temp != null) {
            return temp.getData();
        }
        return null;
    }

    public boolean contain(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getData().equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Node<T> removeAtIndex(int index) {
        Node<T> previous = null;
        Node<T> temp = head;
        int count = 0;
        while (count != index && temp != null) {
            count++;
            previous = temp;
            temp = temp.next;
        }
        if (temp != null) {
            if (previous != null) {
                previous.next = temp.next;
            } else {
                head = temp.next;
            }
        }
        return temp;
    }

    public Node<T> removeFromBegining() {
        Node<T> temp = head;
        head = temp.next;
        return temp;
    }

    public Node<T> removeFromEnd() {
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node<T> deleted = temp.next;
        temp.next = null;
        return deleted;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            str.append("->").append(temp.getData());
            temp = temp.next;
        }
        return str.toString();
    }
}
