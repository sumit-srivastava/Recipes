package com.java.se7.cooked;

import java.util.*;

/**
 * Created by ssri52 on 3/3/2017.
 */
public class LRUCacheUsingListMap<K, V>  {
    private static final int CAPACITY = 1000;
    private int size;
    private List<V> data;
    private Map<K,V> map;

    public LRUCacheUsingListMap() {
        this(CAPACITY);
    }

    public LRUCacheUsingListMap(int capacity) {
        size = capacity;
        data = new ArrayList<>();
        map = new HashMap<>();
    }

    public V get(K key) {
        if (data.size() == 0) {
            throw new IllegalStateException("Cache is empty.");
        }
        V value = null;
        if (map.containsKey(key)) {
            value = map.get(key);
            data.remove(value);
            data.add(value);
        }
        return value;
    }

    public void add(K key, V value) {
        if (data.size() == size) {
            if (map.containsKey(key)) {
                data.remove(value);
            } else {
                data.remove(0);
            }
        }
        if (map.containsKey(key)) {
            data.remove(value);
        }
        map.put(key, value);
        data.add(value);
    }

    public void remove(K key) {
        if (map.containsKey(key)) {
            V value = map.remove(key);
            data.remove(value);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data.toArray());
    }

    public static void main(String[] args) {
        LRUCacheUsingListMap<String, Integer> cache = new LRUCacheUsingListMap(5);
        cache.add("One", 1);
        cache.add("Two", 2);
        cache.add("Three", 3);
        cache.get("Two");
        cache.add("Four", 4);
        cache.add("Five", 5);
        cache.remove("Five");
        cache.add("Six", 6);
        cache.add("Seven", 7);
        System.out.println(cache);

    }
}
