package com.java.se7.data.structures.list;

/**
 * @author sumitsrivastava
 */
public class CircularlyLinkedList<E> {

    private static class Node<E> {

        /*
         * reference to the element stored at this node
         */
        private E element;
        /*
         * reference to the subsequent node in the list
         */
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    /*
     * last node of the list (null if empty)
     */
    private Node<E> tail = null;
    /*
     * size of the list
     */
    private int size = 0;

    /*
     * constructs an initially empty list
     */
    public CircularlyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        else
            return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        else
            return tail.getElement();
    }

    /**
     * rotate the first element to the back of the list
     */
    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            // since it is circular, in case of one element i.e. tail element
            // only it will point next to itself.
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) {
        // add first element and then set the new element as tail since it is in circular.
        addFirst(e);
        tail = tail.getNext();
    }


    public E removeFirst() {
        if (isEmpty())
            return null;

        Node<E> head = tail.getNext();
        if (head == tail)
            tail = null;
        else
            tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }
}
