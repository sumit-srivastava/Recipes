package com.java.se7.data.structures.list;

import java.util.*;

/**
 * @author sumitsrivastava
 */
public class LRUCacheDLL<K,V> {

    private static class Node<K,V> {

        /*
         * reference to the element stored at this node
         */
        private K key;
        private V value;
        /*
         * reference to the previous node in the list
         */
        private Node<K,V> prev;
        /*
         * reference to the subsequent node in the list
         */
        private Node<K,V> next;

        public Node(K key, V value, Node<K,V> prev, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }

        public Node<K,V> getPrev() {
            return prev;
        }

        public void setPrev(Node<K,V> prev) {
            this.prev = prev;
        }

        public Node<K,V> getNext() {
            return next;
        }

        public void setNext(Node<K,V> next) {
            this.next = next;
        }
    }

    /*
     * header sentinel: it doesn't contain element.
     */
    private Node<K,V> header;
    /*
     * trailer sentinel: it doesn't contain element.
     */
    private Node<K,V> trailer;
    /*
     * size of the list
     */
    private int size = 0;

    private Map<K, Node<K,V>> nodeMap;

    private int cacheSize;

    /*
     * constructs an initially empty list
     */
    public LRUCacheDLL(int cacheSize) {
        // create header
        header = new Node<>(null, null, null, null);
        // trailer is preceded by header
        trailer = new Node<>(null, null, header, null);
        // header is followed by trailer
        header.setNext(trailer);
        nodeMap = new HashMap<>();
        this.cacheSize = cacheSize;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void addBetween(K key, V value, Node<K,V> predecessor, Node<K,V> successor) {
        if (size() == cacheSize) {
            Node<K,V> node = trailer.getPrev();
            remove(node);
        }
        Node<K,V> newest = new Node<>(key, value, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        nodeMap.put(key, newest);
        size++;
    }

    private void remove(Node<K,V> node) {
        Node<K,V> predecessor = node.getPrev();
        Node<K,V> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        nodeMap.remove(node.getKey());
        size--;
    }

    private void addFirst(K key, V value) {
        addBetween(key, value, header, header.getNext());
    }

    public void put(K key, V value) {
        if (nodeMap.containsKey(key)) {
            Node<K,V> node = nodeMap.get(key);
            remove(node);
        }
        addFirst(key,value);
    }

    public V get(K key) {
        if (!nodeMap.containsKey(key)) {
            return null;
        } else {
            Node<K,V> node = nodeMap.get(key);
            remove(node);
            addFirst(key, node.getValue());
            return node.getValue();
        }
    }

    private Map.Entry<K,V> createEntry(K key, V value){
        return new Map.Entry<K, V>() {
            @Override
            public K getKey() {
                return key;
            }

            @Override
            public V getValue() {
                return value;
            }

            @Override
            public V setValue(V value) {
                return null;
            }
        };
    }

    public Collection<Map.Entry<K,V>> getAll() {
        List<Map.Entry<K,V>> list = new ArrayList<>();
        if (size() > 0) {
            Map.Entry<K,V> entry = createEntry(header.getNext().getKey(), header.getNext().getValue());
            list.add(entry);
            Node<K,V> node = header.getNext();
            for (int i = 1; i < size(); i++) {
                node = node.getNext();
                entry = createEntry(node.getKey(), node.getValue());
                list.add(entry);
            }
        }
        return list;
    }

    public static void main (String[] args) {
        LRUCacheDLL<String,String> c = new LRUCacheDLL<String, String>(3);
        c.put ("1", "one");                           // 1
        c.put ("2", "two");                           // 2 1
        c.put ("3", "three");                         // 3 2 1
        c.put ("4", "four");                          // 4 3 2
        if (c.get("2") == null) throw new Error();    // 2 4 3
        c.put ("5", "five");                          // 5 2 4
        c.put ("4", "second four");                   // 4 5 2
        // List cache content.
        for (Map.Entry<String, String> e : c.getAll())
            System.out.println (e.getKey() + " : " + e.getValue()); }
}

