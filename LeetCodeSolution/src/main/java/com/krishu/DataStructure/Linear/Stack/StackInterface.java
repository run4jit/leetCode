package com.krishu.DataStructure.Linear.Stack;


//public class CustomStackException extends RuntimeException {
//    CustomStackException(String msg) {
//        super(msg);
//    }
//
//    public void CustomStackOverflowException(String message, Throwable cause) {
//        super(message, cause);
//    }
//}
public interface StackInterface<T> {
    public void push(T num);
    public T pop();
    public T peek();
    public int size();
}
