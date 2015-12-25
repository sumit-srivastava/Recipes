package com.java.se7.data.structures.list;

import com.java.se7.data.structures.common.Position;

/**
 * @author sumitsrivastava
 */
public class DoublyLinkedPositionalList<E> implements PositionalList<E> {

    private static class Node<E> implements Position<E> {

        private E element;      // reference to the element stored at this node
        private Node<E> prev;   // reference to the previous node in the list
        private Node<E> next;   // reference to to the subsequent node in the list

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if (next == null)
                throw new IllegalStateException("Position no longer valid");
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

    private Node<E> header;     // header sentinel
    private Node<E> trailer;    // trailer sentinel
    private int size = 0;       // number of elements in the list

    /** Constructs a new empty list */
    public DoublyLinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);   // trailer is preceded by header
        header.setNext(trailer);
    }

    // private utilities
    /** Validates the position and returns it as a node. */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>)p;
        if (node.getNext() == null)     // as per convention of defunct node defined in remove()
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    /** Returns the given node as a Position (or null, if it is a sentinel). */
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer)
            return null;        // do not expose user to the sentinels
        return node;
    }

    /** Adds element e to the linked list between the given nodes. */
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> node = new Node<>(e, pred, succ);
        pred.setNext(node);
        succ.setPrev(node);
        size++;
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    @Override
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer, trailer.getPrev());
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    /** Replaces the element stored at Position p and returns the replaced element. */
    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    /** Removes the element stored at Position p and returns it (invalidating p). */
    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);          // help with garbage collection
        node.setNext(null);             // and convention for defunct node
        node.setNext(null);
        return answer;
    }
}
