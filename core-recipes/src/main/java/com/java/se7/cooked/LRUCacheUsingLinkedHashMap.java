package com.java.se7.cooked;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ssri52 on 3/3/2017.
 */
public class LRUCacheUsingLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static int CACHE_SIZE=5;
    private static float LOAD_FACTOR = 0.75f;
    private static boolean ACCESS_ORDER = true;

    public LRUCacheUsingLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    protected boolean removeEldestEntry(Map.Entry eldest) {
        if (size() > CACHE_SIZE) {
            System.out.println("Size limit reached, removing eldest entry:"+eldest.getKey());
            return true;
        } else {
            return false;
        }
    }

    public static void main (String[] args) {
        LRUCacheUsingLinkedHashMap<String, String> cache = new LRUCacheUsingLinkedHashMap<>(CACHE_SIZE, LOAD_FACTOR , ACCESS_ORDER);
        cache.put("a","a");cache.put("b","b");
        cache.put("c","c");cache.put("d","d");
        cache.put("e","e");cache.put("b","b");
        cache.put("d","d");cache.put("b","b");
        cache.put("c","c");cache.put("b","b");
        cache.put("a","a");cache.put("f","f");
        cache.get("a");
        System.out.println("size:"+cache.size());
        Set<String> keys = cache.keySet();
        for (String key : keys) {
            System.out.println("Cache contains:"+key);
        }
    }
}
