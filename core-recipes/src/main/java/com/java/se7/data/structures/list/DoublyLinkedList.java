package com.java.se7.data.structures.list;

/**
 * @author sumitsrivastava
 */
public class DoublyLinkedList<E> {

    private static class Node<E> {

        /*
         * reference to the element stored at this node
         */
        private E element;
        /*
         * reference to the previous node in the list
         */
        private Node<E> prev;
        /*
         * reference to the subsequent node in the list
         */
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }
        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    /*
     * header sentinel
     */
    private Node<E> header;
    /*
     * trailer sentinel
     */
    private Node<E> trailer;
    /*
     * size of the list
     */
    private int size = 0;

    /*
     * constructs an initially empty list
     */
    public DoublyLinkedList() {
        // create header
        header = new Node<>(null, null, null);
        // trailer is preceded by header
        trailer = new Node<>(null, header, null);
        // header is followed by trailer
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        else
            return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        else
            return trailer.getPrev().getElement();
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public  void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        else
            return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty())
            return null;
        else
            return remove(trailer.getPrev());
    }

}
