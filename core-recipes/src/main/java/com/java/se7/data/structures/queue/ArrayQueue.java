package com.java.se7.data.structures.queue;

/**
 * Created by ssri52 on 2/23/2017.
 */
public class ArrayQueue<E> implements Queue<E> {

    // generic array used for storage.
    private E[] data;

    // index of the front element.
    private int f = 0;

    // current number of elements.
    private int sz = 0;

    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return (sz == 0);
    }

    /**
     * Adds a new element to the back of queue.
     */
    @Override
    public void enqueue(E e) {
        if (sz == data.length) {
            throw new IllegalStateException("Queue is full.");
        }
        int avail = (f+sz) % data.length;
        data[avail] = e;
        sz++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[f];
        f = (f+1) % data.length;
        sz--;
        return answer;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[f];
    }
}
