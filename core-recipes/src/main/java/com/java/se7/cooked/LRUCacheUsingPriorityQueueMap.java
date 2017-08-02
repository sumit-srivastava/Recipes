package com.java.se7.cooked;

import java.util.*;

/**
 * Created by ssri52 on 3/3/2017.
 */
public class LRUCacheUsingPriorityQueueMap<K, V> {
    private static final int CAPACITY = 5;
    private int size;
    private Map<K, V> map;
    private PriorityQueue<Element<K>> pq;

    private static class Element<K> {
        private K key;
        private Date timestamp;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Element<?> element = (Element<?>) o;

            return getKey().equals(element.getKey());

        }

        @Override
        public int hashCode() {
            return getKey().hashCode();
        }
    }

    public LRUCacheUsingPriorityQueueMap() {
        this(CAPACITY);
    }

    public LRUCacheUsingPriorityQueueMap(int capacity) {
        size = capacity;
        map = new HashMap<>();

        /**
         * We know that Queue follows First-In-First-Out model but sometimes we need to process the
         * objects in the queue based on the priority. That is when Java PriorityQueue is used.
         *
         * For example, let’s say we have an application that generates stocks reports for daily trading session.
         * This application processes a lot of data and takes time to process it. So customers are sending
         * request to the application that is actually getting queued but we want to process premium customers
         * first and standard customers after them. So in this case PriorityQueue implementation in java can be
         * really helpful.
         *
         * PriorityQueue is an unbounded queue based on a priority heap and the elements of the priority queue
         * are ordered by default in natural order. We can provide a Comparator for ordering at the time of
         * instantiation of priority queue.
         *
         * Java Priority Queue doesn’t allow null values and we can’t create PriorityQueue of Objects that are
         * non-comparable. We use java Comparable and Comparator for sorting Objects and Priority Queue use
         * them for priority processing of it’s elements.
         *
         * The head of the priority queue is the least element based on the natural ordering or comparator
         * based ordering, if there are multiple objects with same ordering, then it can poll any one of them
         * randomly. When we poll the queue, it returns the head object from the queue.
         *
         * Java Priority Queue size is unbounded but we can specify the initial capacity at the time of it’s
         * creation. When we add elements to the priority queue, it’s capacity grows automatically.
         *
         * Java Priority Queue implementation provides O(log(n)) time for enqueing and dequeing method.
         *
         * http://www.journaldev.com/1642/java-priority-queue-priorityqueue-example
         *
         */
        pq = new PriorityQueue<>(size, new Comparator<Element<K>>() {
            @Override
            public int compare(Element<K> o1, Element<K> o2) {
                return o1.getTimestamp().compareTo(o2.getTimestamp());
            }
        });
    }

    public V get(K key) {
        V value = map.get(key);
        if (value != null) {
            update(key);
        }
        return value;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            update(key);
            // value might be new
            map.put(key, value);
        } else {
            if (map.size() >= size) {
                K leastUsed = remove();
                map.remove(leastUsed);
            }
            // Add a new element in cache
            Element<K> element = new Element<>();
            element.setTimestamp(new Date());
            element.setKey(key);
            insert(element);
            map.put(key, value);
        }
    }

    private K remove() {
        Element<K> leastUsed = pq.poll();
        return leastUsed.getKey();
    }

    /**
     * Since this key could from any position so to reorder it must be removed and added back
     * so that PriorityQueue can arrange this at a position as per its priority.
     */
    private void update(K key) {
        Iterator<Element<K>> pqIterator = pq.iterator();
        while (pqIterator.hasNext()) {
            Element<K> element = pqIterator.next();
            if (element.getKey().equals(key)) {
                pqIterator.remove();
                break;
            }
        }
        Element<K> mostRecent = new Element<>();
        mostRecent.setTimestamp(new Date());
        mostRecent.setKey(key);
        insert(mostRecent);
    }

    private void insert(Element<K> mostRecent) {
        pq.offer(mostRecent);
    }


    public static void main(String[] args) {
        LRUCacheUsingPriorityQueueMap<String, String> cache = new LRUCacheUsingPriorityQueueMap<>();
        cache.put("a","a");
        cache.put("b","b");
        cache.put("c","c");
        cache.put("d","d");
        cache.put("e","e");
        cache.put("b","b");
        cache.put("d","d");
        cache.put("b","b");
        cache.put("c","c");
        cache.put("b","b");
        cache.put("a","a");
        cache.put("f","f");
        cache.get("a");
    }
}
