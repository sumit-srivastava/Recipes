package com.java.se7.data.structures.tree;

import com.java.se7.data.structures.common.Position;

import java.util.Iterator;

/**
 * @author sumitsrivastava
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    protected static class Node<E> implements Position<E> {

        private E element;          // an element stored at this node
        private Node<E> parent;     // a reference to the parent node (if any)
        private Node<E> left;       // a reference to the left node (if any)
        private Node<E> right;      // a reference to the right node (if any)

        /** Constructs a node with the given element and neighbors. */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return null;
        }
    }

    protected Node<E> root = null;
    private int size = 0;

    /** Constructs an empty binary tree */
    public LinkedBinaryTree() {}

    /** Factory method to create a new node storing element e. */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    /** Validates the position and returns it as a node. */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Not a valid position type");
        Node<E> node = (Node<E>)p;

        /** in this case, as per convention of defunct node under remove(),
         *  a parent feiled of a deeted node refers to the node itself.
         * */
        if (node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public int size() {
        return size;
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if(!isEmpty()) throw new IllegalStateException("ree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (node.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");

        Node<E> leftChild = createNode(e, node, null, null);
        node.setLeft(leftChild);
        size++;
        return leftChild;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (node.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");

        Node<E> rightChild = createNode(e, node, null, null);
        node.setRight(rightChild);
        size++;
        return rightChild;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /** Attaches trees t1 and t2 as left and right subtrees of external. p */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);

        if (isInternal(p)) throw new IllegalArgumentException("p must be a eaf");
        size = t1.size() + t2.size();
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setRight(t1.root);
            t1.root = null;
            t1.size = 0;
        }
    }

    /** Removes the node at Position p and replaces it with its child, if any. */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        if (numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
       Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());

        if (child != null) {
            child.setParent(node.getParent());
        }
        if (node == root)
            root = child;
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);       // our convention for defunct node
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }
}
