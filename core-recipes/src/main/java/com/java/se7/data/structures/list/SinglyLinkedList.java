package com.java.se7.data.structures.list;

/**
 * @author sumitsrivastava
 */
public class SinglyLinkedList<E> {


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
     * first node of the list (null if empty)
     */
    private Node<E> head = null;
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
    public SinglyLinkedList() { }

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
            return head.getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        else
            return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public  void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }


    public E removeFirst() {
        if (isEmpty())
            return null;
        E e = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return e;
    }

    public E findNthToLast(int n) {
        if (isEmpty())
            return null;
        int elementToBeFound = size - n + 1;
        Node<E> node = head;
        for (int i = 1; i < elementToBeFound; i++) {
            node = node.getNext();
        }
        return node.getElement();
    }

    public void reverseListIteratively() {
        if (size() < 2)
            return;
        else {
            Node<E> secondNode = head.getNext();
            Node<E> thirdNode = secondNode.getNext();

            head.setNext(null);
            secondNode.setNext(head);

            if (thirdNode == null) {
                return;
            }

            Node<E> prevNode = secondNode;
            Node<E> currNode = thirdNode;
            Node<E> nextNode;

            while (currNode != null) {
                nextNode = currNode.getNext();
                currNode.setNext(prevNode);

                prevNode = currNode;
                currNode = nextNode;
            }
            head = prevNode;    // prevNode, already pointing next to null
        }

    }

    public void reverseListRecursively() {
        if (head != null && head.getNext() != null)
            head = reverse(head, head.getNext());
    }

    private Node<E> reverse(Node<E> prev, Node<E> curr) {
        Node<E> next = curr.getNext();
        curr.setNext(prev);
        return next == null ? curr : reverse(curr, next);
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for (int i=0;i<20;i++) {
            list.addFirst(i + 1);
        }
        Node<Integer> node1 = list.head;
        for (int i=0;i<20;i++) {
            System.out.print(node1.getElement()+", ");
            node1 = node1.getNext();
        }
        System.out.println("\n" + list.findNthToLast(1));

        list.reverseListRecursively();
        Node<Integer> node2 = list.head;
        for (int i=0;i<20;i++) {
            System.out.print(node2.getElement()+", ");
            node2 = node2.getNext();
        }
    }


    //===============================================================================
    //                      Floyd's cycle detection algorithm
    //===============================================================================

    // Steps
    // 1. Use two pointer fastPtr and slowPtr and initialize both to head of linkedlist
    // 2. Move fastPtr by two nodes and slowPtr by one node in each iteration.
    // 3. If fastPtr and slowPtr meet at some iteration , then there is a loop in linkedlist.
    // 4. If fastPtr reaches to the end of linkedlist without meeting slow pointer then there is no loop in linkedlist.

    public boolean ifLoopExists() {
        Node<E> fastPtr = head;
        Node<E> slowPtr = head;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr =fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    // This case is invalid in the above linked list implementation since the insertion and deletion
    // is at element level not node level.
}
