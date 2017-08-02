package com.java.se7.data.structures.tree;

import java.util.*;

/**
*   A binary tree is made of nodes, where each node contains a "left" pointer, a "right" pointer, and a data element. The "root" pointer 
*   points to the topmost node in the tree. The left and right pointers recursively point to smaller "subtrees" on either side. A null pointer 
*   represents a binary tree with no elements -- the empty tree. The formal recursive definition is: a binary tree is either empty (represented 
*   by a null pointer), or is made of a single node, where the left and right pointers (recursive definition ahead) each point to a binary tree.
*
*            5 
*           / \ 
*          3   9 
*         / \   \
*        1   4  12
*   A "binary search tree" (BST) or "ordered binary tree" is a type of binary tree where the nodes are arranged in order: for each node, all elements 
*   in its left subtree are less-or-equal to the node (<=), and all the elements in its right subtree are greater than the node (>). 
*   
*   The tree shown above is a binary search tree -- the "root" node is a 5, and its left subtree nodes (1, 3, 4) are <= 5, and its right subtree 
*   nodes (9, 12) are > 5. Recursively, each of the subtrees must also obey the binary search tree constraint: in the (1, 3, 4) subtree, the 3 is the root, 
*   the 1 <= 3 and 4 > 3. 
* 
*
*   In order to support the binary search tree property, we require that data stored in each node is Comparable:
*/
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    private class Node<T> {
        private Node<T> left;
        private Node<T> right;
        private T data;

        public Node(T newData) {
            this(newData, null, null);
        }

        public Node(T newData, Node<T> left, Node<T> right) {
            data = newData;
            this.left = left; 
            this.right = right;
        }

        public String toString() {
            return data.toString();
        }
    }

    // root node, will be null for an empty tree.
    private Node<T> root;

    private Comparator<T> comparator;

    // creates an empty tree.
    public BinarySearchTree() {
        root = null;
        comparator = null;
    }

    public BinarySearchTree(Comparator<T> comparator) {
        root = null;
        this.comparator = comparator;
    }

    private int compare(T x, T y) {
        if (comparator == null) {
            return x.compareTo(y);
        } else {
            return comparator.compare(x,y);
        }
    }
    
    /*****************************************************
    *
    *            INSERT
    *
    ******************************************************/

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node insert(Node<T> node, T data) {
        if (node == null) {
            node = new Node<T>(data);
        } 

        if (compare(data, node.data) == 0) {
            return node;
        }

        if (compare(data, node.data) < 0) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    /*****************************************************
    *
    *            SEARCH - returns true if the given element is in the binary tree.
    *
    ******************************************************/
    public boolean lookup(T data) {
        return lookup(root, data);
    }

    // recursive lookup for a given node in top down approach.
    private boolean lookup(Node<T> node, T data) {
        if (node == null) {
            return false;
        } else if (compare(data, node.data) == 0) {
            return true;
        } else if (compare(data, node.data) < 0) {
            return lookup(node.left, data);
        } else {
            return lookup(node.right, data);
        }

    }


    /*****************************************************
    *
    *            DELETE
    *
    ******************************************************/
    public void delete(T data) {
        delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node==null) {
            throw new RuntimeException("cannot delete.");
        } else if(compare(data, node.data) == 0) {
            node.left = delete(node.left, data);
        } else if(compare(data, node.data) == 0) {
            node.right = delete(node.right, data);
        } else {
            // if data is same as node.data

            // node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            } 

            // node with two children: Get the inorder successor (smallest in the right subtree)
            node.data = minValue(node.right);

            // delete the inorder successor
            node.right = delete(node.right, node.data);
        }
        return node;
    }


    /**
    *   Returns the min value in a non-empty binary search tree. 
    */
    public T minValue() {
        return minValue(root);
    }

    private T minValue(Node<T> node) {
        Node<T> current = node;
        while(current.left != null) {
            current = current.left;
        }
        return current.data;
    }


    public int size() {
        return size(root);
    }

    private int size(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    /**
    *    Returns the max root-to-leaf depth of the tree. 
    */
    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            // use the larger + 1
            return Math.max(lDepth, rDepth) + 1;
        }
    }


    /*************************************************
     *
     *            TRAVERSAL
     *
     **************************************************/
    
    /**
    *   Prints the node values in the "inorder" order. 
    */
    public void printTree() {
        printTree(root);
        System.out.println();
    }

    private void printTree(Node<T> node) {
        if (node == null) {
            return;
        } 

        // left, node itself, right
        printTree(node.left);
        System.out.println(node.data + " ");
        printTree(node.right);
    }

    private void printPreOrder(Node<T> node) {
        if (node == null) {
            return;
        }

        // first parent, then left and right
        System.out.println(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    /**
    *   Prints the node values in the "postorder" order. 
    */
    public void printPostorder() {
        printPostorder(root);
    }

    private void printPostorder(Node<T> node) {
        if (node == null) {
            return;
        }

        // first recur on both subtrees
        printPostorder(node.left);
        printPostorder(node.right);

        // then deal with the node
        System.out.println(node.data + " ");
    }


    /** 
    *   Given a tree and a sum, returns true if there is a path from the root 
    *   down to a leaf, such that adding up all the values along the path 
    *   equals the given sum.
    *
    *   Strategy: subtract the node value from the sum when recurring down, 
    *   and check to see if the sum is 0 when you run out of tree. 
*/ 
//    public boolean hasPathSum(int sum) {
//        return hasPathSum(root, sum);
//    }
//
//    private boolean hasPathSum(Node<T> node, int sum) {
//        // return true if run out of tree and sum==0
//        if (node == null) {
//            return sum == 0;
//        } else {
//            //other check both subtrees
//            int subSum = sum - node.data;
//            return (hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum));
//        }
//
//    }

    public BinarySearchTree<T> clone() {
        BinarySearchTree<T> twin = null;
        if (comparator == null) {
            twin = new BinarySearchTree<T>();
        } else {
            twin = new BinarySearchTree<T>(comparator);
        }
        twin.root = cloneHelper(root);
        return twin;
    }

    private Node<T> cloneHelper(Node<T> node) {
        if (node == null) {
            return null;
        } else {
            return new Node<T>(node.data, cloneHelper(node.left), cloneHelper(node.right));
        }
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node<T> node) {
        if (node == null) {
            return 0;
        } else if(node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeaves(node.left) + countLeaves(node.right);
        }
    } 


    /** 
    *   Given a binary tree, prints out all of its root-to-leaf 
    *   paths, one per line. Uses a recursive helper to do the work.
    public void printPaths() {
        int[] path = new int[1000];
        printPaths(root, path, 0);
    }
    */

    /**
     * Valid for number data only
    private void printPaths(Node<T> node, int[] path, int pathLen) {
        if (node==null) {
            return;
        }
        // append this node to path array.
        path[pathLen] = node.data;
        pathLen++;

        // it's a leaf so print the path that led to here.
        if (node.left==null && node.right==null) {
            printArray(path, pathLen);
        } else {
            // otherwise try both trees
            printPaths(node.left, path, pathLen);
            printPaths(node.right, path, pathLen);
        }

    }
     */

    /** 
    *   Utility that prints ints from an array on one line. 
    */ 
    private void printArray(int[] ints, int len) {
        for (int i=0; i<len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }


    /** 
    *  Changes the tree into its mirror image.
    *
    *   So the tree... 
    *     4 
    *    / \ 
    *   2   5 
    *  / \ 
    * 1   3
    *
    *   is changed to... 
    *     4 
    *    / \ 
    *   5   2 
    *      / \ 
    *     3   1
    *
    *   Uses a recursive helper that recurs over the tree, 
    *   swapping the left/right pointers. 
    */ 
    public void mirror() {
        mirror(root);
    }

    private void mirror(Node<T> node) {
        if (node != null) {
            // do the subtrees
            mirror(node.left);
            mirror(node.right);

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }


    public boolean sameTree(BinarySearchTree<T> other) {
        return sameTree(root, other.root);
    }

    private boolean sameTree(Node<T> a, Node<T> b) {
        // 1. both empty -> true
        if (a==null && b==null) {
            return true;
        } else if(a!=null && b!=null) { // 2. both non-empty -> compare them
            return (a.data == b.data && sameTree(a.left, b.left) && sameTree(a.right, b.right));
        } else {    // 3. one empty, one not -> false
            return false;
        }
    }

    public Iterator<T> iterator() {
        return new InOrderIterator(root);
    }

    // inorder (LPR)
    private class InOrderIterator implements Iterator<T> {
        Deque<Node<T>> queue = new ArrayDeque<Node<T>>();
        public InOrderIterator(Node<T> node) {
            pushLeftChildren(node);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("All nodes have been visited.");
            }

            Node<T> node = queue.pop(); // removes from the top of stack
            pushLeftChildren(node.right);
            return node.data;
        }

        private void pushLeftChildren(Node<T> node) {
            while (node != null) {
                queue.push(node);   // pushes to top of stack
                node = node.left;
            }
        }

        @Override
        public void remove() {}
    }

    // preorder (PLR)
    private class PreOrderIterator implements Iterator<T> {
        /**
         * We can use Stack and handle the process more naturally. Each time when we visit a node, we push its
         * right and left children into the stack so that we can access left subtree first and then right subtree.
         *
         * More specifically, we use ArrayDeque which a "resizable-array implementation of the Deque interface".
         * It provides amortized constant time operations such as add, poll, push, and pop, etc.
         */
        Deque<Node<T>> queue = new ArrayDeque<Node<T>>();
        public PreOrderIterator(Node<T> node) {
            queue.add(node);    // add last
        }


        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("All nodes have been visited.");
            }
            Node<T> nextNodeByPreOrder = queue.pop(); // remove first
            if (nextNodeByPreOrder.right != null) {
                queue.push(nextNodeByPreOrder.right); // add first
            }
            if (nextNodeByPreOrder.left != null) {
                queue.push(nextNodeByPreOrder.left);
            }

            return nextNodeByPreOrder.data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Node cannot be removed.");
        }
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(8);
        bst.insert(5);
        bst.insert(4);
        bst.insert(9);
        bst.insert(7);
        bst.insert(11);
        bst.insert(1);
        bst.insert(12);
        bst.insert(3);
        bst.insert(2);

        Iterator<Integer> itr = bst.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

}