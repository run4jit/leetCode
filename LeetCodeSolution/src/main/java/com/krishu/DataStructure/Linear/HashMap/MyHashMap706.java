package com.krishu.DataStructure.Linear.HashMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class MyHashMap706 {
    final int MAX_ARRAY_SIZE = 10000;
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
    }
    private Node[] map;
    public MyHashMap706() {
        map = new Node[MAX_ARRAY_SIZE];
//        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
//            map[i] = new LinkedList<MapValue>();
//        }
    }
    private Integer getIndex(int key) {
        return Integer.hashCode(key) % MAX_ARRAY_SIZE;
    }
    public void put(int key, int value) {
        int index = getIndex(key);
        map[index] = new Node(key, value);

//       while (map.hasNext()) {
//            head.next();
//       }
    }

    public int get(int key) {
        int index = getIndex(key);
        return map[index].value;
    }

    public void remove(int key) {
        int index = getIndex(key);
        map[index] = null;
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
