package com.java.se7.data.structures.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssri52 on 3/3/2017.
 */
public class ListStack<E> implements Stack<E> {
    private static final int CAPACITY = 1000;
    private int size;
    private List<E> dataList;
    private int t = -1;

    public ListStack() {
        this(CAPACITY);
    }

    public ListStack(int capacity) {
        size = capacity;
        dataList = new ArrayList<>();
    }

    @Override
    public int size() {
        return (t + 1);
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(E e) {
        if (dataList.size() == size()) {
            throw new IllegalStateException("Stack is full.");
        }
        dataList.add(++t, e);
    }

    @Override
    public E pop() {
        if (dataList.size() == 0) {
            throw new IllegalStateException("Stack is empty.");
        }
        E answer = dataList.remove(t--);
        return answer;
    }

    @Override
    public E top() {
        if (dataList.size() == 0) {
            return null;
        }
        return dataList.get(t);
    }
}
