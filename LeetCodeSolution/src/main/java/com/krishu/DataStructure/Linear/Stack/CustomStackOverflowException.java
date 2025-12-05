package com.krishu.DataStructure.Linear.Stack;

public class CustomStackOverflowException extends RuntimeException{
    // Constructor that accepts no arguments
    public CustomStackOverflowException() {
        super();
    }

    // Constructor that accepts a custom message
    public CustomStackOverflowException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause (another Throwable)
    public CustomStackOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause only
    public CustomStackOverflowException(Throwable cause) {
        super(cause);
    }
}
