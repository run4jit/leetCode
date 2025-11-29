package com.krishu.DataStructure.Linear.Stack;

public class CustomStackUnderflowException extends RuntimeException{
    // Constructor that accepts no arguments
    public CustomStackUnderflowException() {
        super();
    }

    // Constructor that accepts a custom message
    public CustomStackUnderflowException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause (another Throwable)
    public CustomStackUnderflowException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause only
    public CustomStackUnderflowException(Throwable cause) {
        super(cause);
    }
}
