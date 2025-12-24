package com.krishu.DataStructure.Linear.HashMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class MyHashMap706 {
    final int MAX_ARRAY_SIZE = 100;
    class MapValue {
        private int key;
        private int value;
        MapValue(int key, int value) {
            this.key = key;
            this.value = value;
        }
        int getValue() {
            return this.value;
        }
        int getKey() {
            return this.key;
        }
    }
    private LinkedList<MapValue>[] map;
    public MyHashMap706() {
        map = new LinkedList[MAX_ARRAY_SIZE];
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            map[i] = new LinkedList<MapValue>();
        }
    }
    private int hashValue(int val) {
        return val % MAX_ARRAY_SIZE;
    }
    public void put(int key, int value) {
        int index = hashValue(key);
        Iterator<MapValue> head = map[index].stream().iterator();
       while (head.hasNext()) {
            head.next();
       }
    }

    public int get(int key) {
        return -1;
    }

    public void remove(int key) {

    }

    @Override
    public String toString() {

        return super.toString();
    }
}
