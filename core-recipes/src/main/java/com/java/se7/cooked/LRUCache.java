package com.java.se7.cooked;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by ssri52 on 3/3/2017.
 */
public class LRUCache<Key, Value> {
    private final int size;
    private ConcurrentLinkedQueue<Key> linkedQueue;
    private ConcurrentHashMap<Key, Value> hashMap;

    /**
     * Cache constructor
     *
     * @param size - size of our cache
     */
    public LRUCache(final int size) {
        this.size = size;
        this.linkedQueue = new ConcurrentLinkedQueue<Key>();
        this.hashMap = new ConcurrentHashMap<Key, Value>(size);
    }

    /**
     * Return the Value corresponding to the given Key in the map. return null if key not found.
     *
     * @param key - Key
     * @return value - Value
     */
    public Value get(final Key key) {
        Value value = null;
        if (hashMap.containsKey(key)) {
            value = hashMap.get(key);
            put(key, value);
        }
        return value;
    }

    /**
     * Add new Key, Value pair to our Map and Queue. If the Key already exists,
     * move it at the beginning of the queue.
     *
     * @param key   - Key
     * @param value - Value
     */
    public synchronized void put(final Key key, final Value value) {
        if (hashMap.containsKey(key)) {
            linkedQueue.remove(key);
        }

        while (linkedQueue.size() >= size) {
            Key oldestKey = linkedQueue.poll();
            if (oldestKey != null) {
                hashMap.remove(oldestKey);
            }

            linkedQueue.add(key);
            hashMap.put(key, value);
        }
    }
}
