package com.java.se7.data.structures.stack;

/**
 * Created by ssri52 on 2/23/2017.
 */
public class ArrayStack<E> implements Stack<E> {

    // default array capacity
    public static final int CAPACITY = 1000;

    // generic array used for storage.
    private E[] data;

    // index of the top element in stack.
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return (t+1);
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full.");
        }
        data[++t] = e;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[t];
    }

    public static <E> void reverse(E[] a) {
        Stack<E> buffer = new ArrayStack<E>(a.length);
        for (int i=0; i<a.length; i++) {
            buffer.push(a[i]);
        }
        for (int i=0; i<a.length; i++) {
            a[i] = buffer.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
    }
}
