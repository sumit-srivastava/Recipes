package com.java.se7.data.structures.stack;

/**
 * Created by ssri52 on 2/23/2017.
 */
public interface Stack<E> {
    /**
     * Returns the number of elements in the stack
     */
    int size();

    /**
     * Tests whether the stack is empty.
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of stack.
     */
    void push(E e);

    /**
     * Removes and returns the top element from the stack.
     */
    E pop();

    /**
     * Returns but does not remove the element at the top of stack.
     */
    E top();
}
