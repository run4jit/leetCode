package com.krishu.DataStructure.Linear.Stack;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CustomStack<T> implements StackInterface<T> {
    private final T[] stack;
    private final int capacity;
    public CustomStack(int size) {
        this.capacity = size;
        this.stack = (T[]) new Object[size];
    }

    private int top = -1;

    @Override
    public void push(T num) {
        if (top < capacity -1) {
            stack[++top] = num;
        } else {
            System.out.println("stack over flow");
            throw new CustomStackOverflowException("Cannot push " + num + ". Stack is full.");
        }
    }

    @Override
    public T pop() {
        if (top >= 0) {
            T temp = stack[top];
//            stack[top] = Integer.MIN_VALUE;
            top--;
            return temp;
        } else {
            System.out.println("stack under flow");
            throw new CustomStackUnderflowException("Cannot pop element. Stack is empty.");
//            return -1;
        }
    }

    @Override
    public T peek() {
        if (top >= 0) {
            return stack[top];
        } else  {
            throw new CustomStackUnderflowException("Cannot pop element. Stack is empty.");
//            return -1;
        }
    }

    @Override
    public int size() {
        return top +1;
    }

    @Override
    public String toString() {
        return Arrays.stream(stack)
                .limit(this.size())
                .map(Object::toString)
                .collect(Collectors.joining("->"));
    }
}
