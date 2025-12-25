package com.krishu.DataStructure.Linear.HashMap;

import java.util.LinkedList;

/*
706. Design HashMap
https://leetcode.com/problems/design-hashmap/description/

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.


Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]


Constraints:

0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.


 */

public class MyHashMap706 {
    final static int MAX_ARRAY_SIZE = 100; // maximum length of the Map
    // Node is used to store the key and value of the map
    class Node {
        private int key;
        private int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
        public void setValue(int val) {
            this.value = val;
        }
        public int getKey() {
            return this.key;
        }

        @Override
        public String toString() {
            return "key: " + getKey() +
                    ", value: " + getValue();
        }
    }

    private LinkedList<Node>[] map;

    public MyHashMap706() {
        // create array of link list of given size
        map = new LinkedList[MAX_ARRAY_SIZE];
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            map[i] = new LinkedList<>(); // initiate with empty list
        }
    }
    private Integer getIndex(int key) {
        // create index of given key
        return Integer.hashCode(key) % MAX_ARRAY_SIZE;
    }
    public void put(int key, int value) {
        int index = getIndex(key); // get index for given key
        Node obj = new Node(key, value); // get the new node with key and value
        LinkedList<Node> list = map[index]; // get the link list.
        if (list != null) {
            for (Node node : list) {
                if (node.getKey() == key) { // update the value if key exist then return
                    node.setValue(value);
                    return;
                }
            }
            list.add(obj); // add new node into the link list
        }
    }

    public int get(int key) {
        int index = getIndex(key); // get index for the key
        LinkedList<Node> list = map[index]; // get the link list
        for (Node node : list) { // loop the link list
            if (node.getKey() == key) { // check if key exist then
                // return associated value
                return node.getValue();
            }
        }
        return -1; // other wise return -1;
    }

    public void remove(int key) {
        int index = getIndex(key); // get the index
        LinkedList<Node> list = map[index]; // get the link list
        for (Node node : list) { // loop the link list
            if (node.getKey() == key) { // check key exist or not.
                list.remove(node); // remove the node from link list.
                return; // discard the loop
            }
        }
    }

    // print entire map
    @Override
    public String toString() {
        String str = "[ ";
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            LinkedList<Node> list = map[i];
            str += "{ ";
            for (Node node : list) {
                str += node.toString() + " ";
            }
            str += "}, \n";
        }
        return str + " ]";
    }
}

class Solution706 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        MyHashMap706 myHashMap = new MyHashMap706();
        for (int i = 1; i <= MyHashMap706.MAX_ARRAY_SIZE; i++) {
            int key = i;
            int val = i * 10;
            myHashMap.put(key, val);
        }
        System.out.println(myHashMap.toString());
        myHashMap.remove(2);
        myHashMap.remove(4);
        System.out.println(myHashMap.toString());
        System.out.println(myHashMap.get(21));

        System.out.println(myHashMap.get(10));
        myHashMap.put(10, 1000);
        System.out.println(myHashMap.get(10));

    }
}