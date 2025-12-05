package com.krishu.DataStructure.Linear.Stack;


public class StackTest {
    public static void main(String[] args) {
        testStackFunc();
        testOverFlow();
        testUnderFlow();
        testStringStackFunc();
    }

    public static void testStackFunc() {
        CustomStack<Integer> stack = new CustomStack<>(10);

        System.out.println("size: " + stack.size());

        for (int i = 1; i <= 10; i++) {
            int ran = (int) (Math.floor(Math.random() * 10) + 1); // between 1 and 10
            int randomNumber = ran * 10; // multiplied by 10
            stack.push(randomNumber); // stack hold 10 to 100;
        }
        System.out.println(stack.toString());
        System.out.println("size: " + stack.size());

        System.out.println("peek : " + stack.peek());

        System.out.println("pop : " + stack.pop());
        System.out.println("pop : " + stack.pop());
        System.out.println("pop : " + stack.pop());
        System.out.println("pop : " + stack.pop());

        System.out.println("size: " + stack.size());
        System.out.println(stack.toString());
    }

    public static void testOverFlow() {
        try {
            CustomStack<Integer> stack = new CustomStack<>(1);
            stack.push(1);
            stack.push(2);
        } catch (CustomStackOverflowException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void testUnderFlow() {
        try {
            CustomStack<Integer> stack = new CustomStack<>(10);
            stack.pop();
        } catch (CustomStackUnderflowException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void testStringStackFunc() {

        String text = "Java split text into an array of words easily.";
        String[] words = text.split("\\s+");
        CustomStack<String> stack = new CustomStack<>(words.length);
        System.out.println("size: " + stack.size());

        for (String word : words) {
            stack.push(word);
        }
        System.out.println(stack.toString());
        System.out.println("size: " + stack.size());

        System.out.println("peek : " + stack.peek());

        System.out.println("pop : " + stack.pop());
        System.out.println("pop : " + stack.pop());
        System.out.println("pop : " + stack.pop());
        System.out.println("pop : " + stack.pop());

        System.out.println("size: " + stack.size());
        System.out.println(stack.toString());
    }
}
